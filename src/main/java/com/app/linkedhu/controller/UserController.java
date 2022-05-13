package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }



    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return userService.getOneUserById(userId);
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam(name = "a") String a){
        return userService.getAllUserByUserName(a);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
        return userService.updateOneUser(userId, newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteById(userId);
    }
}
