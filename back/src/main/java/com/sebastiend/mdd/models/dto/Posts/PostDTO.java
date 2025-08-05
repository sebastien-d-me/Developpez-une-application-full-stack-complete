package com.sebastiend.mdd.models.dto.Posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.dto.Topics.TopicDTO;
import com.sebastiend.mdd.models.entities.PostEntity;
import com.sebastiend.mdd.models.entities.TopicEntity;
import com.sebastiend.mdd.models.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PostDTO {
    @JsonProperty("id_posts")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("id_users")
    private UserEntity user;

    @JsonProperty("id_topics")
    private TopicEntity topic;


    /* Convert to DTO */
    public static PostDTO convertDTO(PostEntity entity) {
        return new PostDTO(
            entity.getPostId(), 
            entity.getTitle(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.getUser(),
            entity.getTopic()
        );
    }
}
