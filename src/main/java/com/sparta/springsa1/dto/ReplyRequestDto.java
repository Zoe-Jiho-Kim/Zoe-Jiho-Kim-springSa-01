package com.sparta.springsa1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReplyRequestDto {
    private String Reply;
    //바보같이 여기서 받아버림
    private Long postId;
}