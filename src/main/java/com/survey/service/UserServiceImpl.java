package com.survey.service;

import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}

