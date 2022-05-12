package com.app.linkedhu.response;

import lombok.Data;

@Data
public class FollowResponse {
    Long id;
    boolean isFollowed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
}
