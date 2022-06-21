package com.survey.controller;

import com.survey.dto.UserDTO;
import com.survey.model.User;
import com.survey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll() {
//
//        try{
//            throw new Exception();
//        }
//
//         catch (Exception e) {
//             log.trace("가장 디테일한 로그");
//             log.warn("경고");
//             log.info("정보성 로그");
//             log.debug("디버깅용 로그");
//             log.error("에러" + e.getMessage());
//
//        }
//
//

        List<User> user = userService.findAll();
        List<UserDTO> dtos = user.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


}
