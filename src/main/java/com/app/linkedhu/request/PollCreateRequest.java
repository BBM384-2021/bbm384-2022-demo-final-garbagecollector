package com.app.linkedhu.request;

import lombok.Data;

import java.util.List;

@Data
public class PollCreateRequest {
    String title;
    List<String> choices;

}
