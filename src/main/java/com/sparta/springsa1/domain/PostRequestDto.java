package com.sparta.springsa1.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;

    public PostRequestDto(String title, String username, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }
}
