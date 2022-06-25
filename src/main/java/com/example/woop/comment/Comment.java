package com.example.woop.comment;

import com.example.woop.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    private int commentId;
    private Timestamp createdAt;
    private String writer;
    private String content;

    @ManyToOne
    private Post post;
}
