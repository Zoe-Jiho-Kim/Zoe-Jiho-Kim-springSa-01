package com.sparta.springsa1.repository;

import com.sparta.springsa1.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    //코멘트에 저장해놓은 게시글 id를 이용해 조회
    List<Reply> findByPostIdOrderByModifiedAtDesc(Long postId);

}