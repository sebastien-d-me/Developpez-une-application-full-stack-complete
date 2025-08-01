package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Topics.*;
import com.sebastiend.mdd.repositories.*;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    /* Get all the topics */
    public TopicsListResponseDTO getAll() {
        List<TopicDTO> topics = topicRepository.findAll().stream().map(TopicDTO::convertDTO).collect(Collectors.toList());
        return new TopicsListResponseDTO(topics);
    }
}
