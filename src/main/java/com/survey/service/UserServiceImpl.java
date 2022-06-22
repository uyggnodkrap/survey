package com.survey.service;

import com.survey.dto.UserDTO;
import com.survey.model.User;
import com.survey.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    //세션 부여
    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDTO dto;





    // 전체 회원 조회
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // 회원 가입
    @Override
    public UserDTO save(User newUser) {
        List<User> findUser = userRepository.findByUserName(newUser.getUserName());
        if(findUser.isEmpty()) {
            userRepository.save(newUser);
            dto.setUser(newUser);
            dto.setMsg("회원가입이 정상적으로 완료되었습니다.");
        }else{
            dto.setMsg("중복된 ID입니다. 다른 ID로 가입을 시도하십시오. ");
        }

        return dto;
    }

    // 회원 정보 수정
    @Override
    public UserDTO update(User user) {

        //해당 User의 닉네임으로 DB 접근 > 해당 유저의 정보만 가져옴 (닉네임 중복 불가 유니크 속성)
        List<User> findUser = userRepository.findByUserName(user.getUserName());

        User foundUser = findUser.get(0);

        if(!user.getBankName().isEmpty() || !user.getBankName().isEmpty()){
            foundUser.setBankName(user.getBankName());
        }
        if(!user.getBankAccount().isEmpty() || !user.getBankAccount().isEmpty()){
            foundUser.setBankAccount(user.getBankAccount());
        }
        if(!user.getEmail().isEmpty() || !user.getEmail().isEmpty()){
            foundUser.setEmail(user.getEmail());
        }
        if(!user.getPhoneNumber().isEmpty() || !user.getPhoneNumber().isEmpty()){
            foundUser.setPhoneNumber(user.getPhoneNumber());
        }
        if(!user.getPassword().isEmpty() || !user.getPassword().isEmpty()){
            foundUser.setPassword(user.getPassword());
        }




        userRepository.save(foundUser);
        dto.setUser(foundUser);
        dto.setMsg("정보 수정이 완료되었습니다.");

        return dto;
    }


    // login
    @Override
    public UserDTO loginService(User userLogin, HttpServletRequest request, HttpServletResponse response) {
        List<User> getUser = userRepository.findByUserName(userLogin.getUserName());
        String id=userLogin.getUserName();
        String pwd=userLogin.getPassword();
        if(!getUser.isEmpty()) {
            id = getUser.get(0).getUserName();
            pwd = getUser.get(0).getPassword();
        }

        if(userLogin.getUserName().isEmpty() || userLogin.getPassword().isEmpty()){
            dto.setMsg("아이디 및 비밀번호를 입력해주세요");
        }else if(getUser.isEmpty()){
            dto.setMsg("ID를 잘못 입력하셨습니다. 확인하시고 다시 시도해주세요.");
        }else if (id.equals(userLogin.getUserName()) && pwd.equals(userLogin.getPassword())) {
            //세션에 아이디 저장
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            //쿠키에 아이디 저장
            Cookie ck = new Cookie("ck_userid", id);
            ck.setMaxAge(60 * 60 * 3); //3시간 유효
            dto.setMsg("로그인");
        }

        return dto;
    }

    // 로그아웃 서비스 (세션 해제)
    @Override
    public String logoutService(HttpSession session) {
        //로그아웃 처리
        session.invalidate();
        return "redirect:/api/v1";
    }

    /**
     * 세션 생성
     */
    public void createSession(Object value, HttpServletResponse response) {

        // 세션 id를 생성하고, 값을 세션에 저장
        // randomUUID() : 확실한 랜덤값을 얻을 수 있음. 자바가 제공
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        // 쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
        // 쿠기를 찾음
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    /**
     * 세션 만료
     */
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            // 만료된 쿠키를 지움
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    // 쿠키를 찾는 로직
    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }

}
