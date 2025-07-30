package com.sebastiend.mdd.models.dto.Topics;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.TopicEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class TopicsListResponseDTO {
    @JsonProperty("topics")
    private List<TopicEntity> topics;
}
