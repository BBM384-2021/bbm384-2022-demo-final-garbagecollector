package com.app.linkedhu.controller;

import com.app.linkedhu.config.PasswordUtils;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.request.UserLoginRequest;
import com.app.linkedhu.request.UserRegisterRequest;
import com.app.linkedhu.response.UserResponse;
import com.app.linkedhu.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.regex.Pattern;
@CrossOrigin
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
                if(user.get().isActive()){
                    boolean passwordMatch = PasswordUtils.verifyUserPassword(userLoginRequest.getPassword(), foundUser.getPassword(), foundUser.getSalt());
                    if (passwordMatch){
                        userResponse.setId(foundUser.getId());
                        userResponse.setUserName(foundUser.getUserName());
                        userResponse.setUserType(foundUser.getUserType());
                        userResponse.setMsg("Login is successful");
                        userResponse.setEnable(foundUser.isActive());
                        return userResponse;
                    }else {
                        userResponse.setMsg("Invalid Password");
                        return userResponse;
                    }
                }
                else{
                    userResponse.setMsg("You are not enable to login. Wait for admin approval");
                    return userResponse;
                }
        }
        else
            userResponse.setMsg("There is not an existing user with user name '"+userLoginRequest.getUserName()+"'");
            return userResponse;
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
        else if(!checkEmail(userRegisterRequest.getEmail())){
            userResponse.setMsg("invalid Email");
        }
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(userRegisterRequest.getPassword(), salt);
        user.setPassword(mySecurePassword);
        user.setSalt(salt);
        user.setUserType(userRegisterRequest.getUserType());
        user.setActive(false);
        userResponse.setUserName(userRegisterRequest.getUserName());
        userResponse.setUserType(userResponse.getUserType());
        userService.saveOneUser(user);

        return userResponse;
        //email unik, confirm password eşleşcek, username unik, tüm bilgiler dolu olcak, şifre min 4 hane,
    }
    public boolean checkEmail(String email) {
        // utilizing pattern matching to check for a valid email
        String emailRegex = "^[a-zA-Z0-9+&*-]+(?:\\."+
                "[a-zA-Z0-9+&-]+)@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}