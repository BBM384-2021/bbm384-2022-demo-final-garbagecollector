package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;


    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public List<User> getAllDisabled(){
        return userService.getAllDisabled();
    }


    @PutMapping("/enable")
    public void enableUser(@RequestParam(name = "userId") Long userId){
        userService.enableUser(userId);
    }
}
