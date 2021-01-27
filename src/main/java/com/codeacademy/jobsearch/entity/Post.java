package com.codeacademy.jobsearch.entity;



import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //part-time or full-time
    private String type;

    @Lob
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    private String location;

    @Column(name = "apply_url")
    private String applyUrl;

    @Column(name = "company_url")
    private String companyUrl;

    @Column(name = "logo_url")
    private String logoUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

}
