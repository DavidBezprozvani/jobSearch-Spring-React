package com.codeacademy.jobsearch.service.mapper;

import com.codeacademy.jobsearch.entity.*;
import com.codeacademy.jobsearch.entity.dto.ApplicationDTO;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DtoToEntityMapper {

    /**
     * Converts from Post DTO to Post entity
     */
    public Post convertPostDtoToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setType(postDTO.getType());
        post.setDescription(postDTO.getDescription());
        post.setSummary(postDTO.getSummary());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setLocation(postDTO.getLocation());
        post.setTitle(postDTO.getTitle());
        post.setApplyUrl(postDTO.getApplyUrl());
        return post;

    }

    /**
     * Converts from Company DTO to Company entity
     */
    public Company convertCompanyDtoToEntity(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCompanyName(companyDTO.getCompanyName());
        company.setRegistrationCode(companyDTO.getRegistrationCode());
        company.setAddress(companyDTO.getAddress());
        company.setLogoUrl(companyDTO.getLogoUrl());
        company.setCompanyUrl(companyDTO.getCompanyUrl());
        return company;
    }

    /**
     * Converts from User DTO to User entity
     */
    public User convertUserDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setProfilePictureUrl(userDTO.getProfilePictureUrl());
        return user;
    }

    /**
     * Converts from Application DTO to Application entity
     */
    public Application convertCompanyDtoToEntity(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setTitle(applicationDTO.getTitle());
        application.setBody(applicationDTO.getBody());
        return application;
    }
}

