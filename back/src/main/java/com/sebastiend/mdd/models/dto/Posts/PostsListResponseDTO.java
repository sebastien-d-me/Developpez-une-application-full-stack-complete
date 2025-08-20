package com.sebastiend.mdd.models.dto.Posts;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;


@AllArgsConstructor
@Data
public class PostsListResponseDTO {
    @JsonProperty("posts")
    private List<PostDTO> posts;
}
