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
public class EntityToDtoMapper {

    /**
     * Converts from Post entity to Post DTO
     */
    public PostDTO convertPostEntityToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setType(post.getType());
        postDTO.setCompanyName(post.getCompany().getCompanyName());
//        postDTO.setCompanyName(post.getCompanyName());
        postDTO.setDescription(post.getDescription());
        postDTO.setSummary(post.getSummary());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());
        postDTO.setCompanyUrl(post.getCompanyUrl());
        postDTO.setApplyUrl(post.getApplyUrl());
        postDTO.setLogoUrl(post.getCompany().getLogoUrl());
        return postDTO;

    }

    /**
     * Converts from Company entity to Company DTO
     */
    public CompanyDTO convertCompanyEntityToDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setLogoUrl(company.getLogoUrl());
        return companyDTO;
    }

    /**
     * Converts from User entity to User DTO
     */
    public UserDTO convertUserEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setProfilePictureUrl(user.getProfilePictureUrl());
        return userDTO;
    }

    /**
     * Converts from Application entity to Application DTO
     */
    public ApplicationDTO convertApplicationEntityToDTO(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setTitle(application.getTitle());
        applicationDTO.setBody(application.getBody());
        return applicationDTO;
    }
}
