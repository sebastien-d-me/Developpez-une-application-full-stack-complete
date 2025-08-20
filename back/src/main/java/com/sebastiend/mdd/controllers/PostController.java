package com.sebastiend.mdd.controllers;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sebastiend.mdd.models.dto.Posts.*;
import com.sebastiend.mdd.services.PostService;


@RestController
public class PostController {
    @Autowired
    private PostService postService;


    /* Get all the posts */
    @GetMapping("/api/posts")
    public ResponseEntity<Object> getTopics() {
        try {
            PostsListResponseDTO response = postService.getAll();
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get a specific post */
    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Object> getPost(@PathVariable Integer postId) {
        try {
            Optional<PostDTO> response = postService.getPost(postId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Publish the post */
    @PostMapping("/api/posts")
    public ResponseEntity<Object> publishPost(@RequestBody PostCreateDTO data) {
        try {
            PostResponseDTO response = postService.publishPost(data);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get posts where user is suscribed */
    @PostMapping(value= "/api/posts/subscribed")
    public ResponseEntity<Object> getPostsWhereSubscribed(@RequestBody List<Integer> topicIds) {
        try {
            PostsListResponseDTO response = postService.getPostsWhereSubscribed(topicIds);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
