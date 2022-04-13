package com.arjuncodes.studentsystem.controller;


import com.arjuncodes.studentsystem.model.User;
import com.arjuncodes.studentsystem.service.UserService;
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
