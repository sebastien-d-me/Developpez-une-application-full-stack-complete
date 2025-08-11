package com.sebastiend.mdd.models.dto.Posts;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PostCreateDTO {
    @JsonProperty("id_posts")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("user")
    private Integer user;

    @JsonProperty("topic")
    private Integer topic;


    /* Convert to DTO */
    public static PostCreateDTO convertDTO(PostEntity entity) {
        return new PostCreateDTO(
            entity.getPostId(), 
            entity.getTitle(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.getUser().getUserId(),
            entity.getTopic().getTopicId()
        );
    }
}
