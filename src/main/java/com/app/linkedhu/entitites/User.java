package com.app.linkedhu.entitites;

//import lombok.Data;

import javax.persistence.*;

@Entity
@Table
//@Data
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Username", unique = true)
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "Admin")
    private boolean admin;
    @Column(name = "UserType")
    private String userType;

    public User(Long id, String username, String password, String email, boolean admin, String userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
        this.userType = userType;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
