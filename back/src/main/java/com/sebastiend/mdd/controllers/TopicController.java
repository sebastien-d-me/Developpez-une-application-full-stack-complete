package com.sebastiend.mdd.controllers;


import com.sebastiend.mdd.models.dto.Topics.TopicsListResponseDTO;
import com.sebastiend.mdd.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
