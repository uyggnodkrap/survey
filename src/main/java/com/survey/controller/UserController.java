package com.survey.controller;

import com.survey.model.User;
import com.survey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> findAll() {

        try{
            throw new Exception();
        }

         catch (Exception e) {
             log.trace("가장 디테일한 로그");
             log.warn("경고");
             log.info("정보성 로그");
             log.debug("디버깅용 로그");
             log.error("에러" + e.getMessage());

        }




        return userService.findAll();
    }

}
