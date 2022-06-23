package com.survey.controller;

import com.survey.model.Survey;
import com.survey.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {
    @Autowired
    private ResultService surveyService;

    @GetMapping()
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

}
