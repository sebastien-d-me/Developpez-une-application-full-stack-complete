package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Topics.*;
import com.sebastiend.mdd.models.entities.*;
import com.sebastiend.mdd.repositories.*;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;


@Data
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private UserRepository userRepository;

    private JwtDecoder jwtDecoder;


    /* Get all the topics */
    public TopicsListResponseDTO getAll() {
        List<TopicDTO> topics = topicRepository.findAll().stream().map(TopicDTO::convertDTO).collect(Collectors.toList());
            
        return new TopicsListResponseDTO(topics);
    }


    /* Get the topics for a specific user */
    public TopicsListResponseDTO getSubscribed() {
        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Le compte n'existe pas.");
        } 

        // Get all subscriptions
        List<Integer> allSubscriptions = subscribeRepository.findByUserId(userCheckExist.getUserId()).stream().map(SubscribeEntity::getTopicId).collect(Collectors.toList());       
        

        // Get all topics
        List<TopicDTO> topics = topicRepository.findAll().stream()
            .map(topic -> new TopicDTO(
                topic.getId(),
                topic.getTitle(),
                topic.getContent(),
                topic.getCreatedAt(),
                topic.getUpdatedAt(),
                allSubscriptions.contains(topic.getId())
            )).collect(Collectors.toList());

        return new TopicsListResponseDTO(topics);
    }


    /* Subscribe a specific topic for a specific user */
    public void subscribeTopicForUser(Integer topicId) {
        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Le compte n'existe pas.");
        } 

        // Save the data
        SubscribeEntity subscribeEntity = new SubscribeEntity();
        subscribeEntity.setUserId(userCheckExist.getUserId());
        subscribeEntity.setTopicId(topicId);
        subscribeRepository.save(subscribeEntity);
    }


    /* Unsubscribe a specific topic for a specific user */
    @Transactional
    public void unsubscribeTopicForUser(Integer topicId) {
        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Le compte n'existe pas.");
        } 

        // Remove the data
        subscribeRepository.deleteByTopicIdAndUserId(topicId, userCheckExist.getUserId());
    }
}
