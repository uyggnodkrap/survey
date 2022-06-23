package com.survey.service;

import com.survey.dto.survey.SurveyCreateByUserRequestDto;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;

    @Transactional
    public Survey createSurvey(SurveyCreateByUserRequestDto dto, User user) {
        Survey survey = Survey.builder()
                // 설문조사가 create될 때는 '등록 전'을 의미하는 int 값을 임의로 넣어줌
                .publishState(0)
                .required(dto.getRequired())
                .surveyName(dto.getSurveyName())
                .user(user)
                .build();

        return surveyRepository.save(survey);
    }

    public Survey getSurveyByUser(Integer surveyId, Integer userId) {
        Survey survey = surveyRepository.findBysurveyIdAndUser_userId(surveyId, userId);
        // 예외처리 어떻게 할 지 아직 모르겠음..
//                .orElseThrow(() -> {
//                    throw new IllegalArgumentException("존재하지 않는 설문조사입니다.");
//                });
        return survey;
    }

}
