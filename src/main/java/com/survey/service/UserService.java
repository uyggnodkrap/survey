package com.survey.service;

import com.survey.dto.UserDTO;
import com.survey.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface UserService {
    public List<User> findAll();

    // 회원 가입
    public UserDTO save(User newUser);

    // 회원 정보 수정
    public UserDTO update(User user);

    //public UserDTO loginService(User userLogin);

    UserDTO loginService(User userLogin, HttpServletRequest request, HttpServletResponse response);

    String logoutService(HttpSession session);
}
