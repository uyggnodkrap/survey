package com.survey.service;

import com.survey.dto.UserDTO;
import com.survey.dto.UserResponseDTO;
import com.survey.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface UserService {

    User getUser(Long userId);
    public List<User> findAll();

    User findById(Long surveyId);

//    User  update(UserDTO userDTO);
    // 회원 가입
    public UserResponseDTO save(User newUser);

    // 회원 정보 수정
    public UserResponseDTO update(User user);

    //public UserDTO loginService(User userLogin);

    UserResponseDTO loginService(User userLogin, HttpServletRequest request, HttpServletResponse response);

    String logoutService(HttpSession session);

}
