package com.survey.service;

import com.survey.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findAll();

    User findByUserNameAndPassword(String name, String password);
}
