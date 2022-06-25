package com.example.woop.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostLoginReq {
    @NotNull(message = "userIdOne must be provided")
    private String userIdOne;

    @NotNull(message = "password must be provided")
    private String password;
}
