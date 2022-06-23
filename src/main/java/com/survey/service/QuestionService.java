package com.survey.service;

import com.survey.dto.survey.question.QuestionCreateRequestDto;
import com.survey.model.Question;
import com.survey.model.Survey;

public interface QuestionService {

    Question createQuestion(QuestionCreateRequestDto dto, Survey survey);

}