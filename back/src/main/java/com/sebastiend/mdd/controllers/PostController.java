package com.sebastiend.mdd.controllers;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Posts.PostCreateDTO;
import com.sebastiend.mdd.models.dto.Posts.PostDTO;
import com.sebastiend.mdd.models.dto.Posts.PostResponseDTO;
import com.sebastiend.mdd.models.dto.Posts.PostsListResponseDTO;
import com.sebastiend.mdd.services.PostService;


@RestController
public class PostController {
    @Autowired
    private PostService postService;


    /* Get all the posts */
    @GetMapping("/api/posts")
    public ResponseEntity<?> getTopics() {
        try {
            PostsListResponseDTO response = postService.getAll();
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get a specific post */
    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Integer postId) {
        try {
            Optional<PostDTO> response = postService.getPost(postId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Publish the post */
    @PostMapping("/api/posts")
    public ResponseEntity<?> publishPost(@RequestBody PostCreateDTO data) {
        try {
            PostResponseDTO response = postService.publishPost(data);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get subscribed posts */
    @PostMapping(value= "/api/posts/subscribed")
    public ResponseEntity<?> getPostsWhereSubscribed(@RequestBody List<Integer> topicIds) {
        try {
            PostsListResponseDTO response = postService.getPostsWhereSubscribed(topicIds);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
