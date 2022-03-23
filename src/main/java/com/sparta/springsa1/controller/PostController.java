package com.sparta.springsa1.controller;

import com.sparta.springsa1.domain.Post;
import com.sparta.springsa1.domain.PostRepository;
import com.sparta.springsa1.domain.PostRequestDto;
import com.sparta.springsa1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;
/////////////////////////////////////////////////////////////

    @GetMapping("/posts/posting")
    public ModelAndView post(){
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("/insert.html");
      return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView main(){
        ModelAndView main = new ModelAndView();
        main.setViewName("/index.html");
        return main;
    }

    @RequestMapping("/posts/detail")
    public ModelAndView detail(@RequestParam("id") Long id) throws Exception{
        ModelAndView mav = new ModelAndView("/detail.html");
        return mav;
    }

    @GetMapping("/posts/detail/{id}")
    public Post getDetail (@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null"));
    }


//////////////////////////////////////////////////////////


    @PostMapping("/posts/posting")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/posts/list")
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/posts/delete/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }

    @PutMapping("/posts/update/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.update(id, requestDto);
        return id;
    }
}
