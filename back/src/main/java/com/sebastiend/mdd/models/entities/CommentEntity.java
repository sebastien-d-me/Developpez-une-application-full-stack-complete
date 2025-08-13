package com.sebastiend.mdd.models.entities;


import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comments", columnDefinition = "int")
    private Integer commentId;

    @Column(name="content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", columnDefinition = "int")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_posts", referencedColumnName = "id_posts", columnDefinition = "int")
    private PostEntity post;
}
