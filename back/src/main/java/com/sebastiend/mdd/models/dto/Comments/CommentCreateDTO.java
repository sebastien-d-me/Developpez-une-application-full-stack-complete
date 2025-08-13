package com.sebastiend.mdd.models.dto.Comments;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class CommentCreateDTO {
    @JsonProperty("id_comments")
    private Integer id;

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("user")
    private Integer user;

    @JsonProperty("postId")
    private Integer postId;


    /* Convert to DTO */
    public static CommentCreateDTO convertDTO(CommentEntity entity) {
        return new CommentCreateDTO(
            entity.getCommentId(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.getUser().getUserId(),
            entity.getPost().getPostId()
        );
    }
}
