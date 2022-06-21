package com.survey.service;

import com.survey.model.User;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserControllerImp implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserNameAndPassword(String name, String password) {
        System.out.println(name);
        return userRepository.findByUserNameAndPassword(name, password);
    }
}
