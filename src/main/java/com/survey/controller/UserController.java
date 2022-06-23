package com.survey.controller;


import com.survey.dto.UserDTO;
import com.survey.dto.UserResponseDTO;
import com.survey.model.User;
import com.survey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
@Slf4j
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserResponseDTO dto;


    @GetMapping
    public ResponseEntity<?> findAll() {
        List<User> user = userService.findAll();
        List<UserDTO> dtos = user.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //회원 가입
    @PostMapping()
    public UserResponseDTO joinUsUser(@RequestBody User newUser) {
        log.debug("Controller : joinUsUser()");
        return userService.save(newUser);
    }

    //회원 정보 수정
    @PutMapping()
    public UserResponseDTO updateUser(@RequestBody User user) {
        log.debug("Controller : 회원 정보 수정 메서드 동작");
        return userService.update(user);
    }

    @PostMapping("/login")
    public UserResponseDTO loginService(@RequestBody User userLogin, HttpServletRequest request, HttpServletResponse response){
        log.debug("Controller : LoginUser()");
        return userService.loginService(userLogin, request, response);
    }

    @GetMapping("/logout")
    public String logoutService(HttpSession session){
        log.debug("Controller : logout()");
        return userService.logoutService(session);
    }

}
