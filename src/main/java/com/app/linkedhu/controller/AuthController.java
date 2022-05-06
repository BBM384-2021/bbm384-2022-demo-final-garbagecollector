package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.request.UserLoginRequest;
import com.app.linkedhu.request.UserRegisterRequest;
import com.app.linkedhu.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final UserServiceImpl userService;


    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginRequest userLoginRequest){
        Optional<User> user = Optional.ofNullable(userService.getOneUserByName(userLoginRequest.getUserName()));
        if (user.isPresent()){
            User foundUser = user.get();
            if (foundUser.getPassword().equals(userLoginRequest.getPassword())){
                return foundUser;
            }else {
                return null;
            }
        }
        else
            return null;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegisterRequest userRegisterRequest){
        User user = new User();
        if (userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword())){
            user.setUserName(userRegisterRequest.getUserName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            user.setUserType(userRegisterRequest.getUserType());
            userService.saveOneUser(user);
            return user;
        }else
            return null;


    }

}
