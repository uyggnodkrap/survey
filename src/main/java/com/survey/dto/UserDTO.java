package com.survey.dto;

import com.survey.model.User;
import lombok.*;

import java.time.LocalDate;



@Getter
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private LocalDate birth;
    private String email;
    private String bankName;
    private String bankAccount;
    @Builder
    public UserDTO (User user){
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.birth = user.getBirth();
        this.email = user.getEmail();
        this.bankName = user.getBankName();
        this.bankAccount = user.getBankAccount();
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public User toEntity(){
        return User.builder()
                .userName(userName)
                .password(password)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .email(email)
                .bankAccount(bankAccount)
                .bankName(bankName)
                .build();

    }
    }
