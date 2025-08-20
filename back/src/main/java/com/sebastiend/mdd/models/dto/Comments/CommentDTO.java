package com.sebastiend.mdd.models.dto.Comments;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.*;
import com.sebastiend.mdd.models.entities.CommentEntity;
import lombok.*;


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
        String userAnonymous = "anonyme";
        if(entity.getUser() != null) {
            userAnonymous = entity.getUser().getUsername();
        }
        
        return new CommentDTO(
            entity.getCommentId(), 
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            userAnonymous,
            entity.getPost().getPostId()
        );
    }
}
