package com.example.woop.comment;

import com.example.woop.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Comment {
    @Id @GeneratedValue
    private int commentId;
    private Timestamp createdAt;
    private String writer;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
