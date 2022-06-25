package com.example.woop.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostUserReq {
    private int dong;
    private int ho;
    private String adminCode;
    private String nickName;
}
