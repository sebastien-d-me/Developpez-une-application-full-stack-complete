package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Posts.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sebastiend.mdd.repositories.PostRepository;
import lombok.Data;


@Data
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    /* Get all the posts */
    public PostsListResponseDTO getAll() {
        List<PostDTO> posts = postRepository.findAll().stream()
            .map(PostDTO::convertDTO)
            .collect(Collectors.toList());
            
        return new PostsListResponseDTO(posts);
    }
}
