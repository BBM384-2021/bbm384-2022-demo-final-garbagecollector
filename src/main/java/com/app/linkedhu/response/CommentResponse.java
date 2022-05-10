package com.app.linkedhu.response;

import com.app.linkedhu.entitites.Comment;
import lombok.Data;

import java.util.Date;

@Data
public class CommentResponse {
    Long id;
    Long userId;
    String userName;
    String text;
    Date date;

    public CommentResponse(Comment entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.text = entity.getText();
    }
}
