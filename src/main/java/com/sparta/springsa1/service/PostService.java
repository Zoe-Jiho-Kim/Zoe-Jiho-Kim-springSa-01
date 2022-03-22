package com.sparta.springsa1.service;

import com.sparta.springsa1.domain.Post;
import com.sparta.springsa1.domain.PostRepository;
import com.sparta.springsa1.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return id;
    }
}
