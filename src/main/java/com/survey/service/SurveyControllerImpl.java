package com.survey.service;

import com.survey.dto.SurveyDTO;
import com.survey.model.Survey;
import com.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class SurveyControllerImpl implements SurveyService{

    @Autowired
    SurveyRepository surveyRepository;

    @Transactional
    public boolean isSurveyExist(String name){ // 설문조사 이름이 존재하면 true 반환
        return surveyRepository.existsBySurveyName(name);
    }

    @Override
    public Survey save(SurveyDTO surveyDTO) {
        final String surveyName = surveyDTO.getSurveyName();
        if (isSurveyExist(surveyName)) {
            return null;
        }
        System.out.println(surveyDTO);
        return surveyRepository.save(surveyDTO.toEntity());
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public List<Survey> update(SurveyDTO surveyDTO) {
        final Optional<Survey> foundSurvey = surveyRepository.findById(surveyDTO.getSurveyId());
        foundSurvey.ifPresent(newSurvey -> {
            newSurvey.setSurveyName(surveyDTO.getSurveyName());
            newSurvey.setPublishEnd(surveyDTO.getPublishEnd());
            newSurvey.setPublishStart(surveyDTO.getPublishStart());
            newSurvey.setRequired(surveyDTO.getRequired());
            newSurvey.setPublishState(surveyDTO.getPublishState());
            surveyRepository.save(newSurvey);

        });
        return surveyRepository.findAll();
    }
}
