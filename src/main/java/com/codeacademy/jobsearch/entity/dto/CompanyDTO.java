package com.codeacademy.jobsearch.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private String companyName;

    private String address;

    private String logoUrl;
}
