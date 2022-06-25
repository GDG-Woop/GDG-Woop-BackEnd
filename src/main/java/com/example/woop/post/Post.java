package com.example.woop.post;

import com.example.woop.comment.Comment;
import com.example.woop.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id
    private int postId;
    private Timestamp createdAt;
    private String title;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User user;

    private String content;
    private int tag;

    @OneToMany
    private List<Comment> commentId = new ArrayList<>();
}
