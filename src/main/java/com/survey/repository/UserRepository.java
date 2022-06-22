package com.survey.repository;

import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select t from User t")
    List<User> findAll();

//    @Query("select u from User u where u.userName in :userName")
    List<User> findByUserName(@Param("userName") String userName);

    User findByPassword(@Param("password") String password);



}
