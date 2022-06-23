package com.survey.service;

import com.survey.dto.SurveyDTO;
import com.survey.dto.UserDTO;
import com.survey.model.Survey;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SurveyService {
    Survey save(Survey survey);

    List<Survey> findAll();

    Survey update(SurveyDTO surveyDTO);

    ResponseEntity<?> findAllByUser(Long id);

    List<Survey> deleteSurvey(SurveyDTO surveyDTO);
}
