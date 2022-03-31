package com.sparta.springsa1.model;

import com.sparta.springsa1.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Reply extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private long postId;

    @Column(nullable = false)
    private Long userId;

    public Reply(ReplyRequestDto replyRequestDto, Long userId, String username) {
        this.userId = userId;
        this.reply = replyRequestDto.getReply();
        this.postId = replyRequestDto.getPostId();
        this.username = username;
    }

    public void updateReply(ReplyRequestDto requestDto) {
        this.reply = requestDto.getReply();
    }

}
