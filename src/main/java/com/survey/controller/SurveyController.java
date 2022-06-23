package com.survey.controller;

import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping()
    public List<Survey> findAll(){
        return surveyService.findAll();
    }


}
