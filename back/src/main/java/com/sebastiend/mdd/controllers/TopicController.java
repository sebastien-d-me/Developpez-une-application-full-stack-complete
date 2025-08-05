package com.sebastiend.mdd.controllers;


import com.sebastiend.mdd.models.dto.Topics.TopicsListResponseDTO;
import com.sebastiend.mdd.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    
    /* Get all the topics */
    @GetMapping("/api/topics")
    public TopicsListResponseDTO getTopics() {
        return topicService.getAll();
    }


    /* Get the topics for a specifc user */
    @GetMapping("/api/topics/user/{userId}")
    public TopicsListResponseDTO getTopicsForUser(@PathVariable Integer userId) {
        return topicService.getSubscribed(userId);
    }


    /* Unsubscribe a specific topic for a specifc user */
    @DeleteMapping("/api/topics/{topicId}/user/{userId}")
    public ResponseEntity<Void> unsubscribeTopicForUser(@PathVariable Integer topicId, @PathVariable Integer userId) {
        topicService.unsubscribeTopicForUser(topicId, userId);
        return ResponseEntity.noContent().build();
    }
}
