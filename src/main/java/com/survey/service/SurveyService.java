package com.survey.service;

import com.survey.model.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> findAll();
}