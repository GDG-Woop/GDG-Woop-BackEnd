package com.example.woop.post.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostBoardRequest {

    @NotNull(message = "title must be provided")
    private String title;

    @NotNull(message = "content must be provided")
    private String content;

    @NotNull(message = "tag must be provided")
    private int tag;
}
