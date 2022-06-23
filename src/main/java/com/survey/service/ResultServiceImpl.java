package com.survey.service;

import com.survey.model.Survey;
import com.survey.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository repository;

    public List<Survey> findAll() {
        return repository.findAll();


    }
}
