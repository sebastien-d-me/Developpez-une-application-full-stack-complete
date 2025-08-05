package com.sebastiend.mdd.repositories;


import com.sebastiend.mdd.models.entities.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SubscribeRepository extends JpaRepository<SubscribeEntity, Integer> {
    List<SubscribeEntity> findByUserId(Integer userId);

    void deleteByTopicIdAndUserId(Integer topicId, Integer userId);
}