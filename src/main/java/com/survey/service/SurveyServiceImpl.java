package com.survey.service;

import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository repository;

    public List<Survey> findAll() {
        return repository.findAll();
    }
}
