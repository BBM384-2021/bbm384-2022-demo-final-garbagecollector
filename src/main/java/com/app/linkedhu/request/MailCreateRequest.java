package com.app.linkedhu.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MailCreateRequest {
    Long id;
    String title;
    String text;
    Long senderUserId;
    Long receiverUserId;
    Boolean isMass;

    public Boolean isMass() {
        return isMass;
    }

    public void setMass(Boolean mass) {
        isMass = mass;
    }
}
