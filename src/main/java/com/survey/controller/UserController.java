package com.survey.controller;

import com.survey.model.User;
import com.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

}
