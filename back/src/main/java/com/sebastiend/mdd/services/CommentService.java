package com.sebastiend.mdd.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.models.dto.Comments.CommentCreateDTO;
import com.sebastiend.mdd.models.dto.Comments.CommentDTO;
import com.sebastiend.mdd.models.dto.Comments.CommentListResponseDTO;
import com.sebastiend.mdd.models.dto.Comments.CommentResponseDTO;
import com.sebastiend.mdd.models.entities.CommentEntity;
import com.sebastiend.mdd.models.entities.PostEntity;
import com.sebastiend.mdd.models.entities.UserEntity;
import com.sebastiend.mdd.repositories.CommentRepository;
import com.sebastiend.mdd.repositories.PostRepository;
import com.sebastiend.mdd.repositories.UserRepository;


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
        List<CommentDTO> comments = commentRepository.findAllByPost_PostId(postId).stream()
            .map(CommentDTO::convertDTO)
            .collect(Collectors.toList());

        return new CommentListResponseDTO(comments);
    }


    /* Publish a post */
    public CommentResponseDTO publishComment(@RequestBody CommentCreateDTO data) {
        PostEntity post = postRepository.findById(data.getPostId()).orElse(null);

        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("The user not exist");
        } 

        LocalDateTime currentDate = LocalDateTime.now();

        CommentEntity newComment = new CommentEntity();
        newComment.setContent(data.getContent());
        newComment.setCreatedAt(currentDate);
        newComment.setUpdatedAt(currentDate);
        newComment.setUser(userCheckExist);
        newComment.setPost(post);
        commentRepository.save(newComment);

        return new CommentResponseDTO("Le commentaire a été publié");
    }
}
