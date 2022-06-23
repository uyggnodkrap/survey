package com.survey.dto;

import com.survey.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
public class UserResponseDTO {
    private String msg;
    private User user;
}