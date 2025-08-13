package com.sebastiend.mdd.repositories;


import com.sebastiend.mdd.models.entities.CommentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByPost_PostId(Integer postId);
}