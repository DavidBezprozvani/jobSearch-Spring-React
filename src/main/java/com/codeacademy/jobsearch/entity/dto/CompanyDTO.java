package com.codeacademy.jobsearch.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {

    private Long id;

    @NotBlank
    private String companyName;

    @NotBlank
    private Long registrationCode;

    @NotBlank
    private String address;

    private String logoUrl;

    private String companyUrl;

}
