package com.codeacademy.jobsearch.service.impl;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import com.codeacademy.jobsearch.service.PostService;
import com.codeacademy.jobsearch.service.mapper.DtoMapper;
import com.codeacademy.jobsearch.service.mapper.EntityMapper;
import com.codeacademy.jobsearch.repository.PostRepository;
import com.codeacademy.jobsearch.service.mapper.TypeConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeacademy.jobsearch.entity.Type.FULL_TIME;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private EntityMapper entityMapper;
    private DtoMapper dtoMapper;
    private CompanyRepository companyRepository;
    private TypeConverter typeConverter;


    public PostServiceImpl(PostRepository postRepository, EntityMapper entityMapper, DtoMapper dtoMapper, CompanyRepository companyRepository, TypeConverter typeConverter) {
        this.postRepository = postRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.companyRepository = companyRepository;
        this.typeConverter = typeConverter;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> entityMapper.convertPostEntityToDTO(post))
                .collect(Collectors.toList());
    }


    @Override
    public PostDTO getPostById(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(id);
        }
        Post post = postRepository.getOne(id);
        return entityMapper.convertPostEntityToDTO(post);
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Company company = companyRepository.getOne(postDTO.getCompanyId());
        Post post = dtoMapper.convertPostDtoToEntity(postDTO);
        post.setCompany(company);
        Post savedPost = postRepository.save(post);
        return entityMapper.convertPostEntityToDTO(savedPost, postDTO.getCompanyId());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        Long id = postDTO.getId();
        if (postRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        Post post = postRepository.getOne(id);
        post.setTitle(postDTO.getTitle());
        post.setCompany(companyRepository.getOne(postDTO.getCompanyId()));
        post.setDescription(postDTO.getDescription());
        post.setSummary(postDTO.getSummary());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setLocation(postDTO.getLocation());
        post.setTitle(postDTO.getTitle());
        post.setApplyUrl(postDTO.getApplyUrl());
        typeConverter.convertType(postDTO, post);
        Post updatedPost = postRepository.save(post);
        return entityMapper.convertPostEntityToDTO(updatedPost);
    }

    @Override
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        postRepository.deleteById(id);
    }

    public List<PostDTO> getAllPostsByCompany(Long companyId) {
        if (companyId == null) {
            throw new EntityNotFoundException(companyId);
        }
        return postRepository.findByCompanyId(companyId)
                .stream()
                .map(post -> entityMapper.convertPostEntityToDTO(post))
                .collect(Collectors.toList());
    }

    //TODO: fix me
//    public List<PostDTO> getAllPostsByType(String type) {
//
//        if (postRepository.findByType(type) == null) {
//            throw new javax.persistence.EntityNotFoundException();
//        }
//
//        return postRepository.findByType(type)
//                .stream()
//                .map(post -> entityMapper.convertPostEntityToDTO(post))
//                .collect(Collectors.toList());
//    }

    // TODO: getByType / getByTitle / getByLocation /


}
