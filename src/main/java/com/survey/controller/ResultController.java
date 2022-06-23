package com.survey.controller;

import com.survey.model.QuestionValue;
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
    private ResultService resultService;

    @GetMapping
    public List<QuestionValue> findAll() {
        return resultService.findAll();
    }


}
