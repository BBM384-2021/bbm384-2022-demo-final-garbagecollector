package com.app.linkedhu.response;

import com.app.linkedhu.entitites.Mail;
import lombok.Data;

import java.util.Date;

@Data
public class MailResponse {
    Long id;
    Long senderUserId;
    Long receiverUserId;
    String senderUserName;
    String receiverUserName;
    Date date;
    String title;
    String text;

    public MailResponse(Mail entity){
        this.id = entity.getId();
        this.senderUserId = entity.getSenderUser().getId();
        this.receiverUserId = entity.getReceiverUser().getId();
        this.senderUserName = entity.getSenderUser().getUserName();
        this.receiverUserName = entity.getReceiverUser().getUserName();
        this.date = entity.getDate();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}
