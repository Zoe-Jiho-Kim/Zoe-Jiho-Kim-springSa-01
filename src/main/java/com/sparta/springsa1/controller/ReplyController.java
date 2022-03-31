package com.sparta.springsa1.controller;

import com.sparta.springsa1.dto.ReplyRequestDto;
import com.sparta.springsa1.model.Reply;
import com.sparta.springsa1.repository.ReplyRepository;
import com.sparta.springsa1.security.UserDetailsImpl;
import com.sparta.springsa1.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    //코멘트 보여주기
    @GetMapping("/posts/{id}/replys")
    public List<Reply> getReplys(@PathVariable("id") Long postId) {
        //게시글 번호로 코멘트를 조회해서 해당하는 코멘트만 리턴
        return replyRepository.findByPostIdOrderByModifiedAtDesc(postId);
    }

    //코멘트 생성
    @PostMapping("/api/posts/{id}/replys")
    public Reply createReply(@RequestBody ReplyRequestDto replyRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        //생성시 생성자의 아이디를 받아 함께 저장
        //게시글 아이디는 commentRequestDto에 있음 만들당시 잘 몰라서 여러방식으로 저장함
        Long userId = userDetails.getUser().getId();
        String username = userDetails.getUsername();
        Reply reply = new Reply(replyRequestDto,userId, username);
        return replyRepository.save(reply);
    }

    //코멘트 수정
    @PutMapping("/api/posts/{postId}/replys/{replyId}")
    public Long updateReplys(@PathVariable Long replyId, @RequestBody ReplyRequestDto requestDto){
        replyService.updateReply(replyId, requestDto);
        return replyId;
    }

    //코멘트 삭제
    @DeleteMapping("/api/posts/{postId}/replys/{replyId}")
    public  String deleteReply(@PathVariable Long replyId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        //삭제시 삭제자의 이름과 생성자의이름을 비교해 같으면 삭제 성공하도록 만들었는데 앞단에서 생성자,삭제자의 이름이 다르면 아예 버튼이 안보이도록 만들어서
        //필요없어짐
        String name = userDetails.getUser().getUsername();
        String replyUserName = replyRepository.findById(replyId).get().getUsername();
        if (Objects.equals(name, replyUserName)){
            replyRepository.deleteById(replyId);
        } else {
            return "삭제실패";
        }
        return "삭제성공";
    }
}