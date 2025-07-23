package com.restclient.Understadning.Rest.Client.controllers;

import com.restclient.Understadning.Rest.Client.model.Post;
import com.restclient.Understadning.Rest.Client.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
