package com.survey.repository;

import com.survey.model.Survey;
import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Boolean existsBySurveyName(String surveyName);


    List<Survey> findByUser(User toEntity);
}
