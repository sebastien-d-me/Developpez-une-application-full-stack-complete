package com.sebastiend.mdd.repositories;


import com.sebastiend.mdd.models.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {}