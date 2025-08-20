package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.dto.Posts.*;
import com.sebastiend.mdd.models.entities.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.repositories.*;
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
        List<PostDTO> posts = postRepository.findAll().stream().map(PostDTO::convertDTO).collect(Collectors.toList());
            
        return new PostsListResponseDTO(posts);
    }


    /* Get a specific post */
    public Optional<PostDTO> getPost(final Integer idPost) {
        return postRepository.findById(idPost).map(post -> PostDTO.convertDTO(post));
    }


    /* Publish a post */
    public PostResponseDTO publishPost(@RequestBody PostCreateDTO data) {
        // Check if there is no topic
        if(data.getTopic() == null) {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }
        TopicEntity topic = topicRepository.findById(data.getTopic()).orElse(null);

        // Check if there is data
        if(data.getTitle() == "" || data.getContent() == "") {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }


        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Veuillez vous reconnecter.");
        } 

        // Get the current date
        LocalDateTime currentDate = LocalDateTime.now();

        // Save the data
        PostEntity newPost = new PostEntity();
        newPost.setTitle(data.getTitle());
        newPost.setContent(data.getContent());
        newPost.setTopic(topic);
        newPost.setCreatedAt(currentDate);
        newPost.setUpdatedAt(currentDate);
        newPost.setUser(userCheckExist);
        postRepository.save(newPost);

        // Return a message
        return new PostResponseDTO("Le post a été publié.");
    }


    /* Get all post where user is subscribed */
    public PostsListResponseDTO getPostsWhereSubscribed(List<Integer> topicIds) {
        List<PostDTO> posts = postRepository.findAllByTopic_IdIn(topicIds).stream().map(PostDTO::convertDTO).collect(Collectors.toList());

        return new PostsListResponseDTO(posts);
    }
}
