package com.survey.controller;

import com.survey.model.Survey;
import com.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping()
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

}