package com.example.woop.post;

import com.example.woop.comment.Comment;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private int postId;

    @CreationTimestamp
    private Timestamp createdAt;
    private String title;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private int tag;

    @JsonBackReference
    @OneToMany
    private List<Comment> commentId = new ArrayList<>();

    public Post(PostBoardRequest postBoardRequest, User user) {
        this.tag = postBoardRequest.getTag();
        this.user = user;
        this.title = postBoardRequest.getTitle();
        this.content = postBoardRequest.getContent();
    }
}
