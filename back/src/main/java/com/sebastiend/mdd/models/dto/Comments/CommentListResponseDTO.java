package com.sebastiend.mdd.models.dto.Comments;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;


@AllArgsConstructor
@Data
public class CommentListResponseDTO {
    @JsonProperty("comments")
    private List<CommentDTO> comments;
}
