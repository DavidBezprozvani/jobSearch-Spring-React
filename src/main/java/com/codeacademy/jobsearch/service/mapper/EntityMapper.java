package com.codeacademy.jobsearch.service.mapper;

import com.codeacademy.jobsearch.entity.*;
import com.codeacademy.jobsearch.entity.dto.ApplicationDTO;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityMapper {

    /**
     * Converts from Post entity to Post DTO
     */
    public PostDTO convertPostEntityToDTO(Post post, Long companyId) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setCompanyId(companyId);
        postDTO.setType(post.getType().name());
        postDTO.setDescription(post.getDescription());
        postDTO.setSummary(post.getSummary());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());
        postDTO.setApplyUrl(post.getApplyUrl());
        return postDTO;

    }

    public PostDTO convertPostEntityToDTO(Post post) {
        return convertPostEntityToDTO(post, post.getCompany().getId());
    }

    /**
     * Converts from Company entity to Company DTO
     */
    public CompanyDTO convertCompanyEntityToDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setRegistrationCode(company.getRegistrationCode());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setLogoUrl(company.getLogoUrl());
        companyDTO.setCompanyUrl(company.getCompanyUrl());
        return companyDTO;
    }

    /**
     * Converts from User entity to User DTO
     */
    public UserDTO convertUserEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setProfilePictureUrl(user.getProfilePictureUrl());
        userDTO.setRoles(user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet()));
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
