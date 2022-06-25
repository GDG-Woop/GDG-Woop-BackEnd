package com.example.woop.post.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMeBoardRes {
    private int dong;
    private int ho;
    private String nickName;

    private String title;
    private String content;
    private int tag;
}
