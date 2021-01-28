package com.codeacademy.jobsearch.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {

    @NotBlank
    private String companyName;

    @Email
    private String email;

    @NotBlank
    private String address;

    private String logoUrl;


}
