package com.survey.controller;

import com.survey.dto.survey.SurveyCreateByUserRequestDto;
import com.survey.dto.survey.SurveyCreateByUserResponseDto;
import com.survey.dto.survey.question.QuestionCreateRequestDto;
import com.survey.dto.survey.question.QuestionCreateResponseDto;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.QuestionService;
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@CrossOrigin("*")
public class SurveyController {

    private final UserService userService;
    private final SurveyService surveyService;

    private final QuestionService questionService;


    // 설문지 생성
    @PostMapping("{userId}")
    @ResponseBody
    public SurveyCreateByUserResponseDto createSurvey(@PathVariable("userId") Integer userId
            , @RequestBody SurveyCreateByUserRequestDto dto) {

        // user 존재 유무 판단
        User user = userService.getUser(userId);

        // survery create
        Survey survey = surveyService.createSurvey(dto, user);

        SurveyCreateByUserRequestDto surveryInfoInDB = SurveyCreateByUserRequestDto.builder()
                .surveyName(survey.getSurveyName())
                .required(survey.getRequired())
                .build();

        SurveyCreateByUserResponseDto responseDto = SurveyCreateByUserResponseDto.builder()
                .msg("survey create success !")
                .userId(user.getUserId())
                .surveyId(survey.getSurveyId())
                .requestData(surveryInfoInDB)
                .publishState(survey.getPublishState())
                .publishStart(survey.getPublishStart())
                .build();

        return responseDto;
    }

    // 질문지 생성
    @PostMapping("{userId}/{surveyId}")
    @ResponseBody
    public QuestionCreateResponseDto createQuestion(@PathVariable("userId") Integer userId
            , @PathVariable("surveyId") Integer surveyId
            , @RequestBody QuestionCreateRequestDto dto) {

        // user 존재 유무 판단
        User user = userService.getUser(userId);

        // user가 생성한 survery 존재 유무 판단
        Survey survey = surveyService.getSurveyByUser(surveyId, userId);

        // question create
        Question question = questionService.createQuestion(dto, survey);

        QuestionCreateRequestDto questionInfoInDB = QuestionCreateRequestDto.builder()
                .questionContent(question.getQuestionContent())
                .build();

        QuestionCreateResponseDto responseDto = QuestionCreateResponseDto.builder()
                .msg("survey's question create success !")
                .userId(user.getUserId())
                .surveyId(question.getSurvey().getSurveyId())
                .questionId(question.getQuestionId())
                .requestData(questionInfoInDB)
                .build();

        return responseDto;
    }
}
