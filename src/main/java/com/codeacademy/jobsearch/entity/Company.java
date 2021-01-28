package com.codeacademy.jobsearch.entity;


import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "registration_code")
    private Long registrationCode;

    @Column(name = "company_name")
    private String companyName;

    private String address;

    @Column(name = "logo_url")
    private String logoUrl;

    @OneToMany
    private List<Post> posts;

}
