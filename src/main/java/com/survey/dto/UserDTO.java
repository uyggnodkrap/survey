package com.survey.dto;

import com.survey.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private LocalDate birth;
    private String email;
    private String bankName;
    private String bankAccount;

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
}
