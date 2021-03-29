package com.codeacademy.jobsearch.controller;


import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class PostController {


    private PostServiceImpl postServiceImpl;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }


    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postServiceImpl.getAllPosts();
    }

    @GetMapping("/company/{companyId}")
    public List<PostDTO> getAllPostsByCompany(@PathVariable Long companyId) {
        return postServiceImpl.getAllPostsByCompany(companyId);
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postServiceImpl.getPostById(id);
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO addPost(@RequestBody @Valid PostDTO postDTO) {
        return postServiceImpl.createPost(postDTO);
    }


    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PostDTO updatePost(@RequestBody @Valid PostDTO postDTO) {
        return postServiceImpl.updatePost(postDTO);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceImpl.deletePost(id);
    }
}
