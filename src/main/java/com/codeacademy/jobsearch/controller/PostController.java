package com.codeacademy.jobsearch.controller;


import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO addPost(@RequestBody @Valid PostDTO postDTO) {
        return postService.createPost(postDTO);
    }


    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PostDTO updatePost(@RequestBody @Valid PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
