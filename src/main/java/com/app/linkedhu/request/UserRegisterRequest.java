package com.app.linkedhu.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String userType;

}
