package com.sebastiend.mdd.models.entities;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "topics")
public class TopicEntity {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    private Integer idTopics;

    @Column(name="title", columnDefinition = "MEDIUMTEXT")
    private String title;

    @Column(name="content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;
}