package com.app.linkedhu.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Data
@Getter
@Setter
public class UserRegisterRequest {

    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String userType;
}
