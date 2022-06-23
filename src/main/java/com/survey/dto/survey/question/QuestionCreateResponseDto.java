package com.survey.dto.survey.question;

import com.survey.dto.survey.question.QuestionCreateRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class QuestionCreateResponseDto {

    String msg;
    Long userId;
    Long surveyId;
    Long questionId;
    QuestionCreateRequestDto requestData;

}
