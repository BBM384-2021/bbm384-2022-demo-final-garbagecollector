package com.app.linkedhu.service;

import com.app.linkedhu.entitites.User;

import java.util.List;

public interface UserService {
     List<User> getAllUsers();
     User saveOneUser(User newUser);
     User getOneUserById(Long userId);
     void deleteById(Long userId);
     User getOneUserByName(String userName);

}
