package com.example.woop.firebase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestDto {
    private String targetToken;
    private String title;
    private String body;
}