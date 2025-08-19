package com.sebastiend.mdd.controllers;


import com.sebastiend.mdd.models.dto.Posts.PostsListResponseDTO;
import com.sebastiend.mdd.models.dto.Topics.TopicsListResponseDTO;
import com.sebastiend.mdd.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    
    /* Get all the topics */
    @GetMapping("/api/topics")
    public ResponseEntity<?> getTopics() {
        try {
            TopicsListResponseDTO response = topicService.getAll();
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get the topics for the logged specifc user */
    @GetMapping("/api/topics/user/subscriptions")
    public ResponseEntity<?> getTopicsForUser() {
        try {
            TopicsListResponseDTO response = topicService.getSubscribed();
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Subscribe a specific topic for a specifc user */
    @PostMapping("/api/topics/{topicId}/user/subscribe")
    public ResponseEntity<?> subscribeTopicForUser(@PathVariable Integer topicId) {
        try {
            topicService.subscribeTopicForUser(topicId);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Unsubscribe a specific topic for a specifc user */
    @DeleteMapping("/api/topics/{topicId}/user/unsubscribe")
    public ResponseEntity<?> unsubscribeTopicForUser(@PathVariable Integer topicId) {
        try {
            topicService.unsubscribeTopicForUser(topicId);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
