package com.survey.repository;

import com.survey.model.Survey;
import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long>  {
//    @Query("select s.*, u.bank_name, u.bank_account from survey s join user u where u.user_id = s.user_id")
//        @Query("select t from Survey t")
//        List<Survey> findAll();

}
