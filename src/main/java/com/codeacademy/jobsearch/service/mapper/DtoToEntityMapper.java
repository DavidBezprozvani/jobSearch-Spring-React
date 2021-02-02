package com.codeacademy.jobsearch.service.mapper;

import com.codeacademy.jobsearch.entity.Application;
import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.ApplicationDTO;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityMapper {

    /**
     * Converts from Post DTO to Post entity
     */
    public Post convertPostDtoToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setType(postDTO.getType());
        post.setCompanyName(postDTO.getCompanyName());
        post.setDescription(postDTO.getDescription());
        post.setSummary(postDTO.getSummary());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setLocation(postDTO.getLocation());
        post.setTitle(postDTO.getTitle());
        post.setCompanyUrl(postDTO.getCompanyUrl());
        post.setApplyUrl(postDTO.getApplyUrl());
        post.setLogoUrl(postDTO.getCompanyUrl());
//        BeanUtils.copyProperties(postDTO, post);
        return post;

    }

    /**
     * Converts from Company DTO to Company entity
     */
    public CompanyDTO convertCompanyDtoToEntity(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        BeanUtils.copyProperties(company, companyDTO);
        return companyDTO;
    }

    /**
     * Converts from User DTO to User entity
     */
    public UserDTO convertUserDtoToEntity(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    /**
     * Converts from Application DTO to Application entity
     */
    public ApplicationDTO convertCompanyDtoToEntity(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(application, applicationDTO);
        return applicationDTO;
    }
}

