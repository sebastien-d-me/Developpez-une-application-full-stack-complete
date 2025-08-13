package com.sebastiend.mdd.services;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sebastiend.mdd.models.dto.Comments.CommentDTO;
import com.sebastiend.mdd.models.dto.Comments.CommentListResponseDTO;
import com.sebastiend.mdd.repositories.CommentRepository;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    /* Get all comments of a specific post */
    public CommentListResponseDTO getCommentsOfPost(Integer postId) {
        List<CommentDTO> comments = commentRepository.findAllByPost_PostId(postId).stream()
            .map(CommentDTO::convertDTO)
            .collect(Collectors.toList());

        return new CommentListResponseDTO(comments);
    }
}
