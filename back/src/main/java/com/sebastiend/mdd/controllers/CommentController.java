package com.sebastiend.mdd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Comments.CommentListResponseDTO;
import com.sebastiend.mdd.services.CommentService;


@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /* Get all the comments from a speciific post */
    @GetMapping("/api/comments/{postId}")
    public CommentListResponseDTO getCommentsOfPost(@PathVariable Integer postId) {
        return commentService.getCommentsOfPost(postId);
    }
}
