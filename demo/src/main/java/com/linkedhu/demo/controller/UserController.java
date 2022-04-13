package com.linkedhu.demo.controller;


import com.linkedhu.demo.model.User;
import com.linkedhu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getById/{userId}")
    public User getById(@PathVariable("userId") Long id){
        return userService.getById(id);
    }


}