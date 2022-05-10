package com.app.linkedhu.controller;

import com.app.linkedhu.config.PasswordUtils;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.request.UserLoginRequest;
import com.app.linkedhu.request.UserRegisterRequest;
import com.app.linkedhu.response.UserResponse;
import com.app.linkedhu.service.UserService;
import org.springframework.http.ResponseEntity;
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
    public UserResponse login(@RequestBody UserLoginRequest userLoginRequest){
        Optional<User> user = Optional.ofNullable(userService.getOneUserByUserName(userLoginRequest.getUserName()));
        UserResponse userResponse = new UserResponse();
        if (user.isPresent()){
            User foundUser = user.get();

            boolean passwordMatch = PasswordUtils.verifyUserPassword(userLoginRequest.getPassword(), foundUser.getPassword(), foundUser.getSalt());
            if (passwordMatch){
                userResponse.setId(foundUser.getId());
                userResponse.setUserName(foundUser.getUserName());
                userResponse.setUserType(foundUser.getUserType());
                userResponse.setMsg("Login is successful");
                return userResponse;
            }else {
                userResponse.setMsg("Invalid Password");
                return null;
            }
        }
        else
            userResponse.setMsg("There is not an existing user with user name '"+userLoginRequest.getUserName()+"'");
            return null;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegisterRequest userRegisterRequest){
        UserResponse userResponse = new UserResponse();
        User user = new User();
        Optional<User> foundUser = Optional.ofNullable(userService.getOneUserByUserName(userRegisterRequest.getUserName()));
        if(foundUser.isPresent()){
            userResponse.setMsg("user name is already taken");
            return userResponse;
        }
        else if(!userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword())){
            userResponse.setMsg("password does not match");
            return userResponse;
        }
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(userRegisterRequest.getPassword(), salt);
        user.setPassword(mySecurePassword);
        user.setSalt(salt);
        user.setUserType(userRegisterRequest.getUserType());
        user.setEnable(false);
        userService.saveOneUser(user);

        return userResponse;
        //email unik, confirm password eşleşcek, username unik, tüm bilgiler dolu olcak, şifre min 4 hane,
    }


}