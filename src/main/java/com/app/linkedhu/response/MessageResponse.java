package com.app.linkedhu.response;

import com.app.linkedhu.entitites.Message;
import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {
    Long id;
    Long senderUserId;
    Long receiverUserId;
    String senderUserName;
    String receiverUserName;
    Date date;
    String text;

    public MessageResponse(Message entity){
        this.id = entity.getId();
        this.senderUserId = entity.getSenderUser().getId();
        this.receiverUserId = entity.getReceiverUser().getId();
        this.senderUserName = entity.getSenderUser().getUserName();
        this.receiverUserName = entity.getReceiverUser().getUserName();
        this.date = entity.getDate();
        this.text = entity.getText();
    }
}
