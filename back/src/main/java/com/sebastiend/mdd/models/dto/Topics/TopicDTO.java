package com.sebastiend.mdd.models.dto.Topics;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.TopicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class TopicDTO {
    @JsonProperty("id_topics")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    private String createdAt;

    @JsonIgnore
    private String updatedAt;

    public static TopicDTO convertDTO(TopicEntity entity) {
        return new TopicDTO(
            entity.getIdTopics(), 
            entity.getTitle(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
