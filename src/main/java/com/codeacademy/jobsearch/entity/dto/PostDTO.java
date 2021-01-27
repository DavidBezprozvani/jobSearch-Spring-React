package com.codeacademy.jobsearch.entity.dto;

import com.codeacademy.jobsearch.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String title;

    @NotBlank
    private String type;

    @NotBlank
    private Company company;

    @NotBlank
    private String description;

    private Instant createdAt;

    @NotBlank
    private String location;

    private String applyUrl;

    private String companyUrl;

    private String logoUrl;
}
