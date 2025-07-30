package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Topics.*;
import com.sebastiend.mdd.models.entities.TopicEntity;
import com.sebastiend.mdd.repositories.*;
import java.util.List;
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
        List<TopicEntity> topics = topicRepository.findAll();
        return new TopicsListResponseDTO(topics);
    }
}
