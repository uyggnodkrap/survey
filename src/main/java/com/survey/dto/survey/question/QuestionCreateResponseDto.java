package com.survey.dto.survey.question;

import com.survey.dto.survey.SurveyCreateByUserRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class QuestionCreateResponseDto {

    String msg;
    Integer userId;
    Integer surveyId;
    Integer questionId;
    QuestionCreateRequestDto requestData;

}
