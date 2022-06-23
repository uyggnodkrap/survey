package com.survey.repository;

import com.survey.model.Survey;
import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("select t from User t")
//    List<User> findAll();
}
