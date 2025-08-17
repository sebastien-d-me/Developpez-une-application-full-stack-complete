package com.sebastiend.mdd.controllers;


import com.sebastiend.mdd.models.dto.Topics.TopicsListResponseDTO;
import com.sebastiend.mdd.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TopicsListResponseDTO getTopics() {
        return topicService.getAll();
    }


    /* Get the topics for the logged specifc user */
    @GetMapping("/api/topics/user/subscriptions")
    public TopicsListResponseDTO getTopicsForUser() {
        return topicService.getSubscribed();
    }


    /* Subscribe a specific topic for a specifc user */
    @PostMapping("/api/topics/{topicId}/user/subscribe")
    public ResponseEntity<Void> subscribeTopicForUser(@PathVariable Integer topicId) {
        topicService.subscribeTopicForUser(topicId);
        return ResponseEntity.noContent().build();
    }


    /* Unsubscribe a specific topic for a specifc user */
    @DeleteMapping("/api/topics/{topicId}/user/unsubscribe")
    public ResponseEntity<Void> unsubscribeTopicForUser(@PathVariable Integer topicId) {
        topicService.unsubscribeTopicForUser(topicId);
        return ResponseEntity.noContent().build();
    }
}
