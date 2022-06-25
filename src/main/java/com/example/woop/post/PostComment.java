package com.example.woop.post;

import com.example.woop.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostComment {
    private String content;
    private User userId;
}
