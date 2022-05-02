package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.exception.PostNotFoundException;
import com.nhnacademy.springmvc.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/{postId}")
public class PostController {
    private final PostRepository postRepository;

    @ModelAttribute("post")
    public Post getPost(@PathVariable("postId") long postId) {
        return postRepository.getPost(postId);
    }

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // TODO #2: 게시물 조회 구현
    @GetMapping
    public String viewPost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "postView";
    }

    // TODO #3: 게시물 수정 form 구현
    @GetMapping("/modify")
    public String postModifyForm(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "postModify";
    }

    @ExceptionHandler(PostNotFoundException.class)
    public String handleException(Model model, PostNotFoundException exc) {
        return null;
    }
}
