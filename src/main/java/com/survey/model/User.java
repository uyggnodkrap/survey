package com.survey.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    private Long userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private LocalDate birth;
    private String email;
    private String bankName;
    private String bankAccount ;

}
