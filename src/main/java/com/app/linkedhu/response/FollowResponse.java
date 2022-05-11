package com.app.linkedhu.response;

import lombok.Data;

@Data
public class FollowResponse {
    Long id;
    boolean isFollowed;

    public FollowResponse(Long id, boolean isFollowed) {
        this.id = id;
        this.isFollowed = isFollowed;
    }
}
