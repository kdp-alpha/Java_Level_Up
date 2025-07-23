package com.restclient.Understadning.Rest.Client.services;

import com.restclient.Understadning.Rest.Client.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<Post> getAllPosts() {
        Post[] posts = restClient.get()
                .uri("/posts")
                .retrieve()
                .body(Post[].class);

        return Arrays.asList(posts);
    }


}
