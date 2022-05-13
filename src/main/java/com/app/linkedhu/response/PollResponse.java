package com.app.linkedhu.response;

import com.app.linkedhu.entitites.Choice;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PollResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    Date date;

    List<Choice> choices;
}
