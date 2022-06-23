package com.survey.dto.survey;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class SurveyCreateByUserResponseDto {

    String msg;
    Integer userId;
    Integer surveyId;
    SurveyCreateByUserRequestDto requestData;
    int publishState;
    LocalDate publishStart;

}
