package com.codeacademy.jobsearch.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {

    @NotBlank
    private String companyName;

    @NotBlank
    private String address;

    private String logoUrl;

    private List<PostDTO> posts;

    private String companyUrl;

}
