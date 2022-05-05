package com.app.linkedhu.service;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.getById(userId);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = Optional.of(userRepository.getById(userId));
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setUserType(newUser.getUserType());
            userRepository.save(foundUser);
            return foundUser;
        }
        else{
             return null;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
