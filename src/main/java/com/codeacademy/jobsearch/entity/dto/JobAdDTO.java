package com.codeacademy.jobsearch.entity.dto;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.JobAd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;


    private String type;

    @ManyToOne
    private Company company;

    private String description;

    private LocalDateTime createdAt;

    private String location;

    private String applyUrl;

    private String companyUrl;

    private String logoUrl;
}
