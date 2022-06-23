package com.survey.repository;

import com.survey.model.Question;
import com.survey.model.QuestionValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionValueRepository extends JpaRepository<QuestionValue, Question> {
}
