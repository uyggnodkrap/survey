package com.survey.service;

import com.survey.dto.SurveyCreateByUserRequestDto;
import com.survey.dto.SurveyDTO;
import com.survey.dto.UserDTO;
import com.survey.model.Survey;
import com.survey.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SurveyService {
    Survey save(Survey survey);

    Survey createSurvey(SurveyCreateByUserRequestDto dto, User user);

    Survey getSurveyByUser(Long surveyId, Long userId);

    List<Survey> findAll();

    Survey update(SurveyDTO surveyDTO);

    ResponseEntity<?> findAllByUser(Long id);

    List<Survey> deleteSurvey(SurveyDTO surveyDTO);

}
