package com.survey.controller;

import com.survey.dto.UserDTO;
import com.survey.model.User;
import com.survey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDTO dto;

    @GetMapping()
    public List<User> findAll() {

        try{
            throw new Exception();
        }

         catch (Exception e) {
             log.trace("가장 디테일한 로그");
             log.warn("경고");
             log.info("정보성 로그");
             log.debug("디버깅용 로그");
             log.error("에러" + e.getMessage());

        }
        return userService.findAll();
    }

    //회원 가입
    @PostMapping()
    public UserDTO joinUsUser(@RequestBody User newUser) {
        log.debug("Controller : joinUsUser()");
        return userService.save(newUser);
    }

    //회원 정보 수정
    @PutMapping()
    public UserDTO updateUser(@RequestBody User user) {
        log.debug("Controller : 회원 정보 수정 메서드 동작");
        return userService.update(user);
    }

    @PostMapping("/login")
    public UserDTO loginService(@RequestBody User userLogin, HttpServletRequest request, HttpServletResponse response){
        log.debug("Controller : LoginUser()");
        return userService.loginService(userLogin, request, response);
    }

    @GetMapping("/logout")
    public String logoutService(HttpSession session){
        log.debug("Controller : logout()");
        return userService.logoutService(session);
    }
}
