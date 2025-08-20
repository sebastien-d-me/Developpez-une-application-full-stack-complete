package com.sebastiend.mdd.models.dto.Comments;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.*;
import lombok.*;


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
}
