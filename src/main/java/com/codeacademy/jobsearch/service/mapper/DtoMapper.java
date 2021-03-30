package com.codeacademy.jobsearch.service.mapper;

import com.codeacademy.jobsearch.entity.*;
import com.codeacademy.jobsearch.entity.dto.ApplicationDTO;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    private CompanyRepository companyRepository;

    public DtoMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Converts from Post DTO to Post entity
     */
    public Post convertPostDtoToEntity(PostDTO postDTO) {
        Post post = new Post();
        Company company = companyRepository.getOne(postDTO.getCompanyId());
        post.setCompany(company);
        post.setDescription(postDTO.getDescription());
        post.setSummary(postDTO.getSummary());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setLocation(postDTO.getLocation());
        post.setTitle(postDTO.getTitle());
        post.setApplyUrl(postDTO.getApplyUrl());
        convertType(postDTO, post);
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
    public Application convertApplicationDtoToEntity(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setTitle(applicationDTO.getTitle());
        application.setBody(applicationDTO.getBody());
        return application;
    }


    public void convertType(PostDTO postDTO, Post post) {
        if (postDTO.getType().equalsIgnoreCase(Type.PART_TIME.name())
                || postDTO.getType().equalsIgnoreCase("part time")
                || postDTO.getType().equalsIgnoreCase("parttime")) {
            post.setType(Type.PART_TIME);
        } else if (postDTO.getType().equalsIgnoreCase(Type.FULL_TIME.name())
                || postDTO.getType().equalsIgnoreCase("full time")
                || postDTO.getType().equalsIgnoreCase("fulltime")) {
            post.setType(Type.FULL_TIME);
        } else if (postDTO.getType().equalsIgnoreCase(Type.INTERNSHIP.name())) {
            post.setType(Type.INTERNSHIP);
        } else if (postDTO.getType().equalsIgnoreCase(Type.REMOTE.name())) {
            post.setType(Type.REMOTE);
        }
    }
}

