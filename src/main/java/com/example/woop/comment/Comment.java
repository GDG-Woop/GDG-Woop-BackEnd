package com.example.woop.comment;

import com.example.woop.comment.request.PostCommentReq;
import com.example.woop.post.Post;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post postId;

    public Comment(PostCommentReq postCommentReq, User user, Post post) {
        this.content = postCommentReq.getContent();
        this.userId = user;
        this.postId = post;
    }
}
