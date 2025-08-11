package com.sebastiend.mdd.models.entities;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "subscribe")
public class SubscribeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_subscribe", columnDefinition = "int")
    private Integer subscribeId;

    @Column(name="id_users", columnDefinition = "int")
    private Integer userId;

    @Column(name="id_topics", columnDefinition =  "int")
    private Integer topicId;
}
