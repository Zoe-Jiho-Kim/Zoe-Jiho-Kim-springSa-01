package com.sparta.springsa1.service;

import com.sparta.springsa1.dto.ReplyRequestDto;
import com.sparta.springsa1.model.Reply;
import com.sparta.springsa1.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Transactional
    public void updateReply(Long replyId, ReplyRequestDto requestDto){
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        reply.updateReply(requestDto);
    }
}
