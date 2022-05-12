package com.app.linkedhu.entitites;

//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
//@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "UserName", unique = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String userName;
    @Column(name = "Password")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String password;
    @Column(name = "Email", unique = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String email;
    @Column(name = "UserType")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String userType;

    @Column(name = "Active")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private boolean active;
    @Column(name = "Salt")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String salt;


    public User(Long id, String userName, String password, String email, String userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.active = false;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isEnable) {
        this.active = isEnable;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
