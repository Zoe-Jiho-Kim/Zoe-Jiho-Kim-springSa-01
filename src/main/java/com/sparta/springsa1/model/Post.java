package com.sparta.springsa1.model;

import com.sparta.springsa1.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends TimeStamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;

    public Post(PostRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
    }

    public void update(PostRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
    }
}
