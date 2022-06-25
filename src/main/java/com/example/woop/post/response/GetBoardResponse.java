package com.example.woop.post.response;

import com.example.woop.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class GetBoardResponse {
    private String title;
    private String content;
    private int tag;

    private List<Comment> commentList;
}
