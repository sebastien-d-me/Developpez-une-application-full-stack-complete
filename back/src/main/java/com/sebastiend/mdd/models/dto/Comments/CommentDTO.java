package com.sebastiend.mdd.models.dto.Comments;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class CommentDTO {
    @JsonProperty("id_comments")
    private Integer id;

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("author")
    private String userUsername;

    @JsonIgnore
    private Integer postId;


    /* Convert to DTO */
    public static CommentDTO convertDTO(CommentEntity entity) {
        return new CommentDTO(
            entity.getCommentId(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.getUser().getUsername(),
            entity.getPost().getPostId()
        );
    }
}
