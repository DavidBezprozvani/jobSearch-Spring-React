package com.codeacademy.jobsearch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_code")
    private Long registrationCode;

    @Column(name = "company_name")
    private String companyName;

    private String address;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "company_url")
    private String companyUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
//    private List<Post> posts = new ArrayList<>();
    private List<Post> posts;

}
