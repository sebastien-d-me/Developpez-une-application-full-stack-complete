package com.sebastiend.mdd.controllers;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Posts.PostCreateDTO;
import com.sebastiend.mdd.models.dto.Posts.PostDTO;
import com.sebastiend.mdd.models.dto.Posts.PostsListResponseDTO;
import com.sebastiend.mdd.services.PostService;


@RestController
public class PostController {
    @Autowired
    private PostService postService;


    /* Get all the posts */
    @GetMapping("/api/posts")
    public PostsListResponseDTO getTopics() {
        return postService.getAll();
    }


    /* Get a specific post */
    @GetMapping("/api/posts/{postId}")
    public Optional<PostDTO> getPost(@PathVariable Integer postId) {
        return postService.getPost(postId);
    }


    /* Publish the post */
    @PostMapping("/api/posts")
    public ResponseEntity<Void> publishPost(@RequestBody PostCreateDTO data) {
        postService.publishPost(data);
        return ResponseEntity.noContent().build();
    }


    /* Get subscribed posts */
    @RequestMapping(value= "/api/posts/subscribed", method = RequestMethod.POST)
    public PostsListResponseDTO getPostsWhereSubscribed(@RequestBody List<Integer> topicIds) {
        return postService.getPostsWhereSubscribed(topicIds);
    }
}
