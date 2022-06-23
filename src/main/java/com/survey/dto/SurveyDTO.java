package com.survey.dto;

import com.survey.model.Survey;

import lombok.*;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurveyDTO {
    private Long surveyId;

    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;


    public SurveyDTO(Survey survey){
        this.surveyId = survey.getSurveyId();
        this.surveyName = survey.getSurveyName();
        this.required = survey.getRequired();
        this.publishState = survey.getPublishState();
        this.publishStart = survey.getPublishStart();
        this.publishEnd = survey.getPublishEnd();
    }
}