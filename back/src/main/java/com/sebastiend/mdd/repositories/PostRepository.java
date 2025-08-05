package com.sebastiend.mdd.repositories;


import com.sebastiend.mdd.models.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {}