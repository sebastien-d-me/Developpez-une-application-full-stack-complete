package com.sebastiend.mdd.models.dto.Topics;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TopicDTO {
    @JsonProperty("id_topics")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;
}
