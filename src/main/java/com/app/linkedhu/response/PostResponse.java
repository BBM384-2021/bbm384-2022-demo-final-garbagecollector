package com.app.linkedhu.response;

import com.app.linkedhu.entitites.Post;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    Date date;
    List<LikeResponse> postLikes;
    List<CommentResponse> postComments;

    public PostResponse(Post entity, List<LikeResponse> likes, List<CommentResponse> comments) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.date = entity.getDate();
        this.postLikes = likes;
        this.postComments = comments;
    }
}
