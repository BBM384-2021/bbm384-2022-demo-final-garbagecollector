package com.app.linkedhu.controller;

import com.app.linkedhu.config.PasswordUtils;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.request.UserLoginRequest;
import com.app.linkedhu.request.UserRegisterRequest;
import com.app.linkedhu.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    private final PasswordUtils passwordUtils;

    public AuthController(UserService userService, PasswordUtils passwordUtils) {
        this.userService = userService;
        this.passwordUtils =passwordUtils;


    }


    @PostMapping("/login")
    public User login(@RequestBody UserLoginRequest userLoginRequest){
        Optional<User> user = Optional.ofNullable(userService.getOneUserByUserName(userLoginRequest.getUserName()));
        if (user.isPresent()){
            User foundUser = user.get();
            boolean passwordMatch = PasswordUtils.verifyUserPassword(userLoginRequest.getPassword(), foundUser.getPassword(), foundUser.getSalt());
            if (passwordMatch){
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
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(userRegisterRequest.getPassword(), salt);
        user.setPassword(mySecurePassword);
        user.setSalt(salt);
        user.setUserType(userRegisterRequest.getUserType());
        user.setEnable(false);
        userService.saveOneUser(user);
        return user;
    }


}