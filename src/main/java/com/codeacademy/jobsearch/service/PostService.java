package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(PostDTO postDTO);

    void deletePost(Long id);

}
