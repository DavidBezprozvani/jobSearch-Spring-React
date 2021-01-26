package com.codeacademy.jobsearch.entity.mapper;

import com.codeacademy.jobsearch.entity.Application;
import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.JobAd;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.ApplicationDTO;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.JobAdDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {

    /**
     * Converts from JobAd entity to JobAd DTO
     */
    public JobAdDTO convertJobAdEntityToJobAdDTO(JobAd jobAd) {
        JobAdDTO jobAdDTO = new JobAdDTO();
        BeanUtils.copyProperties(jobAd, jobAdDTO);
        return jobAdDTO;

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