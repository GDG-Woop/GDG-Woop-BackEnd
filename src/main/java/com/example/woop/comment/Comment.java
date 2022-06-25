package com.example.woop.comment;

import com.example.woop.post.Post;
import com.example.woop.user.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private Timestamp createdAt;

    @OneToOne(optional = false)
    private User user;

    private String content;

    @ManyToOne
    private Post post;
}
