package com.app.linkedhu.response;

import com.app.linkedhu.entitites.User;

public class UserResponse {
    Long id;
    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
    }
}
