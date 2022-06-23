package com.survey.service;

import com.survey.dto.survey.question.QuestionCreateRequestDto;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.repository.QuestionRepository;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public Question createQuestion(QuestionCreateRequestDto dto, Survey survey) {
        Question question = Question.builder()
                .survey(survey)
                .questionContent(dto.getQuestionContent())
                .build();

        return questionRepository.save(question);
    }
}
