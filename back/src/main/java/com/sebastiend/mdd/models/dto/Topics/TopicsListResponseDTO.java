package com.sebastiend.mdd.models.dto.Topics;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;


@AllArgsConstructor
@Data
public class TopicsListResponseDTO {
    @JsonProperty("topics")
    private List<TopicDTO> topics;
}
