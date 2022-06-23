package com.survey.controller;


import com.survey.dto.ResponseDTO;
import com.survey.dto.SurveyDTO;
import com.survey.dto.UserDTO;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/survey")
@Slf4j
public class SurveyController {

    @Autowired
    SurveyService surveyService;
    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<?> findall() {
        List<Survey> categories = surveyService.findAll();
        List<SurveyDTO> dtos = categories.stream().map(SurveyDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/add") // 설문조사 추가
    public ResponseEntity<?> save(@RequestBody SurveyDTO surveyDTO){ // 설문조사 추가
        try{
            User user = userService.findById(surveyDTO.getSurveyId());

            Survey survey = Survey.builder()
                    .surveyName(surveyDTO.getSurveyName())
                    .publishEnd(surveyDTO.getPublishEnd())
                    .publishStart(surveyDTO.getPublishStart())
                    .publishState(surveyDTO.getPublishState())
                    .required(surveyDTO.getRequired())
                    .user(user).build();

            Survey addSurvey = surveyService.save(survey);
            SurveyDTO responseSurveyDTO = SurveyDTO.builder()
                    .surveyId(addSurvey.getSurveyId())
                    .surveyName(addSurvey.getSurveyName())
                    .publishStart(addSurvey.getPublishStart())
                    .publishEnd(addSurvey.getPublishEnd())
                    .publishState(addSurvey.getPublishState())
                    .required(addSurvey.getRequired()).build();
            return ResponseEntity.ok(responseSurveyDTO);

        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PatchMapping("/update") // 설문조사 정보 수정
    public ResponseEntity<?> update(@RequestBody SurveyDTO surveyDTO){

        try{
            Survey survey =surveyService.update(surveyDTO);

            SurveyDTO responseSurveyDTO = SurveyDTO.builder()
                    .surveyId(survey.getSurveyId())
                    .surveyName(survey.getSurveyName())
                    .publishStart(survey.getPublishStart())
                    .publishEnd(survey.getPublishEnd())
                    .publishState(survey.getPublishState())
                    .required(survey.getRequired()).build();
            return ResponseEntity.ok(responseSurveyDTO);

        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/all") // 특정 사용자의 설문조사 리스트 조회
    public ResponseEntity<?> findAllByUser(@RequestParam Long id){
        return surveyService.findAllByUser(id);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSurvey(@RequestBody SurveyDTO surveyDTO){
        try {
            List<Survey> surveyList = surveyService.deleteSurvey(surveyDTO);
            List<SurveyDTO> dtos = surveyList.stream().map(SurveyDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);

        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
