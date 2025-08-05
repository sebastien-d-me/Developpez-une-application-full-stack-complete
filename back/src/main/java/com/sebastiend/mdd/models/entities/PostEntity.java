package com.sebastiend.mdd.models.entities;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_posts", columnDefinition = "int")
    private Integer postId;

    @Column(name="title", columnDefinition = "MEDIUMTEXT")
    private String title;

    @Column(name="content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", columnDefinition = "int")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_topics", referencedColumnName = "id_topics", columnDefinition = "int")
    private TopicEntity topic;
}
