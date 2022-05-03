package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.request.UserLoginRequest;
import com.app.linkedhu.request.UserRegisterRequest;
import com.app.linkedhu.service.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;


    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest userLoginRequest){
        Optional<User> user = Optional.ofNullable(userService.getOneUserByName(userLoginRequest.getUserName()));
        if (user.isPresent()){
            User foundUser = user.get();
            if (foundUser.getPassword().equals(userLoginRequest.getPassword())){
                return "Login is successful";
            }else {
                return "Password not match";
            }
        }
        else
            return "User not found";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequest userRegisterRequest){
        User user = new User();
        if (userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword())){
            user.setUserName(userRegisterRequest.getUserName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            user.setUserType(userRegisterRequest.getUserType());
            userService.saveOneUser(user);
            return "Register is successful";
        }else
            return "Not registered";


    }

}
