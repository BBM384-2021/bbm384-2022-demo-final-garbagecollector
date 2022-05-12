package com.app.linkedhu.service;

import com.app.linkedhu.config.PasswordUtils;
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

    @Autowired
    private PasswordUtils passwordUtils;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.getById(userId);
    }
    public User getOneUserByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }
    public User updateOneUser(Long userId, User newUser) {
                Optional<User> user = Optional.of(userRepository.getById(userId));
                if(user.isPresent()){
                    User foundUser = user.get();
                    if(newUser.getUserName() != null){
                        foundUser.setUserName(newUser.getUserName());
                    }
                    if(newUser.getPassword() != null){
                        String salt = PasswordUtils.getSalt(30);
                        String mySecurePassword = PasswordUtils.generateSecurePassword(newUser.getPassword(), salt);
                        foundUser.setPassword(mySecurePassword);
                        foundUser.setSalt(salt);
                    }
                    if(newUser.getEmail() != null){
                        foundUser.setEmail(newUser.getEmail());
                    }
                    if(newUser.getAvatar() != -1){
                        foundUser.setAvatar(newUser.getAvatar());
                    }
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


    public User getOneUserByEmail(String email) {
        return userRepository.getByEmail(email);

    }

    public void enableUser(Long userId) {
        User user = userRepository.getById(userId);
        user.setActive(true);
        userRepository.save(user);
    }

    public List<User> getAllDisabled() {
        return userRepository.getAllByActiveFalse();
    }

    public List<User> getAllEnabled() {return userRepository.getAllByActiveTrue();
    }
}
