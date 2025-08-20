package com.sebastiend.mdd.models.dto.Posts;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.PostEntity;
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
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("author")
    private String userUsername;

    @JsonProperty("topic")
    private String topicTitle;


    /* Convert to DTO */
    public static PostDTO convertDTO(PostEntity entity) {
        String userAnonymous = "anonyme";
        if(entity.getUser() != null) {
            userAnonymous = entity.getUser().getUsername();
        }

        return new PostDTO(
            entity.getPostId(), 
            entity.getTitle(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            userAnonymous,
            entity.getTopic().getTitle()
        );
    }
}
