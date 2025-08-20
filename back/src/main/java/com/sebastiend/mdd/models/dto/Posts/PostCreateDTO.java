package com.sebastiend.mdd.models.dto.Posts;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.*;
import lombok.*;


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
}
