package com.sebastiend.mdd.models.entities;


import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_users", columnDefinition = "int")
    private Integer userId;

    @Column(name="username", columnDefinition = "MEDIUMTEXT")
    private String username;

    @Column(name="email_address", columnDefinition = "MEDIUMTEXT")
    private String emailAddress;
    
    @Column(name="password", columnDefinition = "MEDIUMTEXT")
    private String password;

    @Column(name="created_at")
     private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
