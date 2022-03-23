package com.sparta.springsa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/api/posts/posting")
    public String post(){
        return "insert";
    }

    @GetMapping("/api/posts")
    public String main(){
        return "index";
    }

    @GetMapping("/api/posts/detail")
    public String detail(@RequestParam("id") Long id){
        return "detail.html";
    }
}
