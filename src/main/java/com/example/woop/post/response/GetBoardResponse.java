package com.example.woop.post.response;

import com.example.woop.comment.Comment;
import com.example.woop.post.Post;
import com.example.woop.post.PostComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class GetBoardResponse {
    private String title;
    private String content;
    private int tag;

    @Nullable
    private List<PostComment> commentList;
}
