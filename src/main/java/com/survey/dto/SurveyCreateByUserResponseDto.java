package com.survey.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class SurveyCreateByUserResponseDto {

    String msg;
    Long userId;
    Long surveyId;
    SurveyCreateByUserRequestDto requestData;
    String publishState;
    LocalDate publishStart;

}
