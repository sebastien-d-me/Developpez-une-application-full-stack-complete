package com.sebastiend.mdd.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.models.dto.Comments.*;
import com.sebastiend.mdd.models.entities.*;
import com.sebastiend.mdd.repositories.*;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    /* Get all comments of a specific post */
    public CommentListResponseDTO getCommentsOfPost(Integer postId) {
        List<CommentDTO> comments = commentRepository.findAllByPost_PostId(postId).stream().map(CommentDTO::convertDTO).collect(Collectors.toList());

        return new CommentListResponseDTO(comments);
    }


    /* Publish a post */
    public CommentResponseDTO publishComment(@RequestBody CommentCreateDTO data) {
        PostEntity post = postRepository.findById(data.getPostId()).orElse(null);

        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Le compte n'existe pas.");
        } 

        // Check if there is content
        if(data.getContent() == "" || data.getContent() == null) {
            throw new IllegalArgumentException("Le contenu du commentaire ne peut pas être vide.");
        }

        // Get the current date
        LocalDateTime currentDate = LocalDateTime.now();

        // Save the data
        CommentEntity newComment = new CommentEntity();
        newComment.setContent(data.getContent());
        newComment.setCreatedAt(currentDate);
        newComment.setUpdatedAt(currentDate);
        newComment.setUser(userCheckExist);
        newComment.setPost(post);
        commentRepository.save(newComment);

        // Return a message
        return new CommentResponseDTO("Le commentaire a été publié");
    }
}
