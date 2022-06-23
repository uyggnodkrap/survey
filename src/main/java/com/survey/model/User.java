package com.survey.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private LocalDate birth;

    @Column(name = "e_mail")
    private String email;
    private String bankName;
    private String bankAccount;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Survey> surveyList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "surveyList=" + surveyList +
                '}';
    }
}