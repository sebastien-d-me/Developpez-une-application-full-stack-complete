package com.sebastiend.mdd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Posts.PostsListResponseDTO;
import com.sebastiend.mdd.services.PostService;


@RestController
public class PostController {
    @Autowired
    private PostService postService;


    /* Get all the posts */
    @GetMapping("/api/posts")
    public PostsListResponseDTO getTopics() {
        return postService.getAll();
    }
}
