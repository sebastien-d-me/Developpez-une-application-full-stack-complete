package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Posts.*;
import com.sebastiend.mdd.models.entities.PostEntity;
import com.sebastiend.mdd.models.entities.TopicEntity;
import com.sebastiend.mdd.models.entities.UserEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.repositories.PostRepository;
import com.sebastiend.mdd.repositories.TopicRepository;
import com.sebastiend.mdd.repositories.UserRepository;
import lombok.Data;


@Data
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;


    /* Get all the posts */
    public PostsListResponseDTO getAll() {
        List<PostDTO> posts = postRepository.findAll().stream()
            .map(PostDTO::convertDTO)
            .collect(Collectors.toList());
            
        return new PostsListResponseDTO(posts);
    }


    /* Get a specific post */
    public Optional<PostDTO> getPost(final Integer idPost) {
        return postRepository.findById(idPost).map(post -> PostDTO.convertDTO(post));
    }


    /* Publish a post */
    public PostResponseDTO publishPost(@RequestBody PostCreateDTO data) {
        TopicEntity topic = topicRepository.findById(data.getTopic()).orElse(null);
        UserEntity user = userRepository.findById(data.getUser()).orElse(null);

        LocalDateTime currentDate = LocalDateTime.now();

        PostEntity newPost = new PostEntity();
        newPost.setTitle(data.getTitle());
        newPost.setContent(data.getContent());
        newPost.setTopic(topic);
        newPost.setCreatedAt(currentDate);
        newPost.setUpdatedAt(currentDate);
        newPost.setUser(user);
        postRepository.save(newPost);

        return new PostResponseDTO("Le post a été publié");
    }
}
