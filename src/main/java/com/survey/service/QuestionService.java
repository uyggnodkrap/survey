package com.survey.service;

import com.survey.dto.QuestionCreateRequestDto;
import com.survey.model.Question;
import com.survey.model.Survey;

public interface QuestionService {

    Question createQuestion(QuestionCreateRequestDto dto, Survey survey);

}
