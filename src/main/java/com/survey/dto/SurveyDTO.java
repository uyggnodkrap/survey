package com.survey.dto;

import com.survey.model.Survey;
import lombok.*;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@ToString
public class SurveyDTO {
    private Long surveyId;
    private int userId;
    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;

    @Builder
    public SurveyDTO(Survey survey){
        this.surveyId = survey.getSurveyId();
        this.userId = survey.getUserId();
        this.surveyName = survey.getSurveyName();
        this.required = survey.getRequired();
        this.publishState = survey.getPublishState();
        this.publishStart = survey.getPublishStart();
        this.publishEnd = survey.getPublishEnd();
    }

    public Survey toEntity(){
        return Survey.builder()
                .userId(userId)
                .required(required)
                .surveyName(surveyName)
                .publishState(publishState)
                .publishStart(publishStart)
                .publishEnd(publishEnd).build();
    }
}
