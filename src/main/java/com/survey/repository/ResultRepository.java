package com.survey.repository;

import com.survey.model.QuestionValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<QuestionValue,Long> {

    @Query("select q from QuestionValue q")
    List<QuestionValue> findAll();

}
