package com.survey.service;

import com.survey.model.QuestionValue;
import com.survey.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository repository;

    @GetMapping
    public List<QuestionValue> findAll() {
        return repository.findAll();


    }
}