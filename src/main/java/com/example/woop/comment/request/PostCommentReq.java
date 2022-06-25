package com.example.woop.comment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostCommentReq {
    private int userId;
    private String content;
}
