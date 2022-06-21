package com.survey.controller;


import com.survey.dto.SurveyDTO;
import com.survey.model.Survey;
import com.survey.service.SurveyService;
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

    @GetMapping
    public ResponseEntity<?> findAll(){ // 모든 설문조사 조회
        List<Survey> survey = surveyService.findAll();
        List<SurveyDTO> dtos = survey.stream().map(SurveyDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/add")
    public Survey save(@RequestBody SurveyDTO surveyDTO){ // 설문조사 추가
        return surveyService.save(surveyDTO);
    }

    @PatchMapping("/update")
    public List<Survey> update(@RequestBody SurveyDTO surveyDTO){
        return surveyService.update(surveyDTO);
    }


}
