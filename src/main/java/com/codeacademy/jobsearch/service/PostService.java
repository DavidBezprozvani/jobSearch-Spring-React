package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import com.codeacademy.jobsearch.service.mapper.DtoMapper;
import com.codeacademy.jobsearch.service.mapper.EntityMapper;
import com.codeacademy.jobsearch.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;
    private EntityMapper entityMapper;
    private DtoMapper dtoMapper;
    private CompanyRepository companyRepository;


    public PostService(PostRepository postRepository, EntityMapper entityMapper, DtoMapper dtoMapper, CompanyRepository companyRepository) {
        this.postRepository = postRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.companyRepository = companyRepository;
    }


    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> entityMapper.convertPostEntityToDTO(post))
                .collect(Collectors.toList());
    }


    public PostDTO getPostById(Long id) {
        Post post = getPostEntityById(id);
        return entityMapper.convertPostEntityToDTO(post);
    }

    public PostDTO createPost(PostDTO postDTO) {
        Company company = companyRepository.getOne(postDTO.getCompanyId());
        Post post = dtoMapper.convertPostDtoToEntity(postDTO);
        post.setCompany(company);
        postDTO.setLogoUrl(post.getCompany().getLogoUrl());
        Post savedPost = postRepository.save(post);
        return entityMapper.convertPostEntityToDTO(savedPost, postDTO.getCompanyId());
    }

    public PostDTO updatePost(PostDTO postDTO) {
        Long id = postDTO.getId();
        if (id == null) {
            throw new EntityNotFoundException(id);
        }
        Post post = getPostEntityById(id);
//        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setCompany(companyRepository.getOne(postDTO.getCompanyId()));
        post.setDescription(postDTO.getDescription());
        post.setSummary(postDTO.getSummary());
        post.setApplyUrl(postDTO.getApplyUrl());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setLocation(postDTO.getLocation());
        post.setType(postDTO.getType());
//        post.setLogoUrl(companyRepository.getOne(postDTO.getCompanyId()).getLogoUrl());

        Post updatedPost = postRepository.save(post);
        return entityMapper.convertPostEntityToDTO(updatedPost);
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        postRepository.deleteById(id);
    }


    // TODO: getByType / getByTitle / getByLocation / getByCompanyId


    Post getPostEntityById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }
}
