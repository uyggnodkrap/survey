package com.survey.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(nullable = false)
    private  String password;

    @Column(name = "phone_number", nullable = false)
    private  String phoneNumber;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(name = "e_mail", nullable = false)
    private  String email;

    @Column(name = "bank_name")
    private  String bankName;

    @Column(name = "bank_account")
    private  String bankAccount;

}
