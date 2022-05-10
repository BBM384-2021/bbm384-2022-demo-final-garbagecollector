package com.app.linkedhu.request;

import lombok.Data;

import java.util.Date;

@Data
public class MailCreateRequest {
    Long id;
    String title;
    String text;
    Date date;
    Long senderUserId;
    Long receiverUserId;
}
