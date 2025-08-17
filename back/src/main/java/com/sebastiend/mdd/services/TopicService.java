package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Topics.*;
import com.sebastiend.mdd.models.entities.SubscribeEntity;
import com.sebastiend.mdd.models.entities.UserEntity;
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
        List<TopicDTO> topics = topicRepository.findAll().stream()
            .map(TopicDTO::convertDTO)
            .collect(Collectors.toList());
            
        return new TopicsListResponseDTO(topics);
    }


    /* Get the topics for a specifc user */
    public TopicsListResponseDTO getSubscribed() {
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("The user not exist");
        } 


        List<Integer> allSubscriptions = subscribeRepository.findByUserId(userCheckExist.getUserId()).stream().map(SubscribeEntity::getTopicId).collect(Collectors.toList());       
        
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
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("The user not exist");
        } 

        SubscribeEntity subscribeEntity = new SubscribeEntity();
        subscribeEntity.setUserId(userCheckExist.getUserId());
        subscribeEntity.setTopicId(topicId);

        subscribeRepository.save(subscribeEntity);
    }


    /* Unsubscribe a specific topic for a specific user */
    @Transactional
    public void unsubscribeTopicForUser(Integer topicId) {
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("The user not exist");
        } 

        subscribeRepository.deleteByTopicIdAndUserId(topicId, userCheckExist.getUserId());
    }
}
