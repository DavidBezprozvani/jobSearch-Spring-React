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
    public PostDTO convertPostEntityToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setType(post.getType());
        postDTO.setCompany(post.getCompany());
        postDTO.setDescription(post.getDescription());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());
        postDTO.setCompanyUrl(post.getCompanyUrl());
        postDTO.setApplyUrl(post.getApplyUrl());
        postDTO.setLogoUrl(post.getLogoUrl());
//        BeanUtils.copyProperties(post, postDTO);

        return postDTO;

    }

    /**
     * Converts from Company entity to Company DTO
     */
    public CompanyDTO convertCompanyEntityToCompanyDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setEmail(company.getEmail());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setLogoUrl(company.getLogoUrl());
//        BeanUtils.copyProperties(company, companyDTO);
        return companyDTO;
    }

    /**
     * Converts from User entity to User DTO
     */
    public UserDTO convertUserEntityToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setProfilePictureUrl(user.getProfilePictureUrl());
//        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    /**
     * Converts from Application entity to Application DTO
     */
    public ApplicationDTO convertCompanyEntityToApplicationDTO(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setTitle(application.getTitle());
        applicationDTO.setBody(application.getBody());
        return applicationDTO;
    }
}
