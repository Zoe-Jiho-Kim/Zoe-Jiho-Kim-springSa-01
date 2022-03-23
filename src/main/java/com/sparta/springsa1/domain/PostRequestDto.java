package com.sparta.springsa1.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String comment;

    public PostRequestDto(String title, String username, String comment) {
        this.title = title;
        this.username = username;
        this.comment = comment;
    }
}
