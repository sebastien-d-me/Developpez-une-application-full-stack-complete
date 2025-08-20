package com.sebastiend.mdd.models.dto.Topics;


import com.fasterxml.jackson.annotation.*;
import com.sebastiend.mdd.models.entities.TopicEntity;
import lombok.*;


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

    private boolean subscribe;


    /* Convert to DTO */
    public static TopicDTO convertDTO(TopicEntity entity) {
        return new TopicDTO(
            entity.getId(), 
            entity.getTitle(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            false
        );
    }
}
