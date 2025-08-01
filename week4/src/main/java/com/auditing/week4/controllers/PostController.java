package com.auditing.week4.controllers;

import com.auditing.week4.dto.PostDTO;
import com.auditing.week4.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

        private final PostService postService;

        @GetMapping
        public List<PostDTO> getAllPosts() {
            return postService.getAllPosts();
        }

        @GetMapping("/{postId}")
        public PostDTO getPostById(@PathVariable Long postId) {
            return postService.getPostById(postId);
        }

        @PostMapping
        public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
            return postService.createNewPost(inputPost);
        }

        @PutMapping("{postId}")
        public PostDTO updatePost(@RequestBody PostDTO inputPost,@PathVariable Long postId ) {
            return postService.updatePost(inputPost, postId);
        }


}


