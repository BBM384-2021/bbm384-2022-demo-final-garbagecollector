package com.app.linkedhu.request;

import lombok.Data;

import java.util.Date;

@Data
public class MessageCreateRequest {
    Long id;
    String text;
    Date date;
    Long senderUserId;
    Long receiverUserId;
}
