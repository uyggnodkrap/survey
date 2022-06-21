package com.survey.service;

import com.survey.dto.SurveyDTO;
import com.survey.model.Survey;

import java.util.List;

public interface SurveyService {
    Survey save(SurveyDTO surveyDTO);

    List<Survey> findAll();

    List<Survey> update(SurveyDTO surveyDTO);
}
