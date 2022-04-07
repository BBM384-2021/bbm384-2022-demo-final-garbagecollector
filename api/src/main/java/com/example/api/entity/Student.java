package com.example.api.entity;



import javax.persistence.*;
import java.util.Date;


@Entity
public class Student {
    @Id

    private Long id;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Boolean isBanned;
    private Date birthday;

    public Student() {
    }

    public Student(String userName, String fullName, String email, String password, Boolean isBanned, Date birthday) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.isBanned = isBanned;
        this.birthday = birthday;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
