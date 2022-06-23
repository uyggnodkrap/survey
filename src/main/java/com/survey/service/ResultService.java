package com.survey.service;

import com.survey.model.QuestionValue;

import java.util.List;

public interface ResultService {
    List<QuestionValue> findAll();
}