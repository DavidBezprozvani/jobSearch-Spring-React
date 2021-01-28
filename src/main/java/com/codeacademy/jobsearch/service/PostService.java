package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.exceptions.PostNotFoundException;
import com.codeacademy.jobsearch.service.mapper.DtoToEntityMapper;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import com.codeacademy.jobsearch.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final EntityToDtoMapper entityMapper;
    private final DtoToEntityMapper dtoMapper;


    public PostService(PostRepository postRepository, EntityToDtoMapper entityMapper, DtoToEntityMapper dtoMapper) {
        this.postRepository = postRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }


    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(jobAd -> entityMapper.convertPostEntityToPostDTO(jobAd))
                .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        Post post = getPostEntityById(id);
        return entityMapper.convertPostEntityToPostDTO(post);
    }

    public PostDTO createPost(PostDTO postDTO) {
        Post post = dtoMapper.convertPostDtoToPostEntity(postDTO);
        Post savedPost = postRepository.save(post);
        postDTO.setId(savedPost.getId());
        return postDTO;
    }

    public PostDTO updatePost(PostDTO postDTO) {
        Long id = postDTO.getId();
        if (id == null) {
            throw new PostNotFoundException(id);
        }
        Post post = getPostEntityById(id);
        BeanUtils.copyProperties(postDTO, post);
        postRepository.save(post);
        return postDTO;
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        postRepository.deleteById(id);
    }


    // TODO: getByType / getByTitle / getByLocation / getByCompanyId / save / update


    Post getPostEntityById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }
}
