package com.app.linkedhu.entitites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Mail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender_user_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    User senderUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="receiver_user_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    User receiverUser;
    String Title;
    //@Column(columnDefinition = "text")
    String text;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return Title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
