package com.app.linkedhu.request;

import lombok.Data;

import java.util.Date;

@Data
public class FollowCreateRequest {
    Long id;
    Date date;
    Long senderUserId;
    Long receiverUserId;
}
