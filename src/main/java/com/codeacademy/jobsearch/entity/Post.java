package com.codeacademy.jobsearch.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;


@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //TODO: ENUMS
    private String type;

    private String description;

    private String summary;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    private String location;

    @Column(name = "apply_url")
    private String applyUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;


}
