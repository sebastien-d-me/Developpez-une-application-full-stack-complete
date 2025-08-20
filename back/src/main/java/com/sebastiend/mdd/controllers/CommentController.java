package com.sebastiend.mdd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sebastiend.mdd.models.dto.Comments.*;
import com.sebastiend.mdd.services.CommentService;


@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /* Get all the comments from a specific post */
    @GetMapping("/api/comments/{postId}")
    public ResponseEntity<Object> getCommentsOfPost(@PathVariable Integer postId) {
        try {
            CommentListResponseDTO response = commentService.getCommentsOfPost(postId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Publish the post */
    @PostMapping("/api/comments")
    public ResponseEntity<Object> publishComment(@RequestBody CommentCreateDTO data) {
        try {
            commentService.publishComment(data);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage()); 
        } 
    }
}
