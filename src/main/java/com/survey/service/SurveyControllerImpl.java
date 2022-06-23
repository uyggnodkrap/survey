package com.survey.service;

import com.survey.dto.ResponseDTO;
import com.survey.dto.SurveyDTO;
import com.survey.dto.UserDTO;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class SurveyControllerImpl implements SurveyService{

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public boolean isSurveyExist(String name){ // 설문조사 이름이 존재하면 true 반환
        return surveyRepository.existsBySurveyName(name);
    }

    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey update(SurveyDTO surveyDTO) {
        try{
            Survey survey = surveyRepository.findById(surveyDTO.getSurveyId()).get();
            survey.setSurveyName(surveyDTO.getSurveyName());
            survey.setRequired(surveyDTO.getRequired());
            survey.setPublishEnd(surveyDTO.getPublishEnd());
            survey.setPublishState(surveyDTO.getPublishState());
            survey.setPublishStart(surveyDTO.getPublishStart());
            return surveyRepository.save(survey);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ResponseEntity<?> findAllByUser(Long id) {
        try{
            User user = userRepository.findById(id).get();
            List<Survey> surveyList = surveyRepository.findByUser(user);
            List<SurveyDTO> surveyDTOList = new ArrayList<>();

            for (Survey survey: surveyList) {
                SurveyDTO surveyDTO = SurveyDTO.builder()
                        .surveyId(survey.getSurveyId())
                        .publishEnd(survey.getPublishEnd())
                        .publishStart(survey.getPublishStart())
                        .surveyName(survey.getSurveyName())
                        .publishState(survey.getPublishState())
                        .required(survey.getRequired())
                        .build();

                surveyDTOList.add(surveyDTO);
            }
            return ResponseEntity.ok(surveyDTOList);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @Override
    public List<Survey> deleteSurvey(SurveyDTO surveyDTO) {
        try{
            Survey survey = surveyRepository.findById(surveyDTO.getSurveyId()).get();
            surveyRepository.delete(survey);
        }
        catch (Exception e){
            e.printStackTrace();
            return surveyRepository.findAll();
        }
        return surveyRepository.findAll();
    }
}
