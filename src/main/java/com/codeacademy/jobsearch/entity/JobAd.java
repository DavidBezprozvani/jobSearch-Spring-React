package com.codeacademy.jobsearch.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class JobAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 7)
    private String title;

    //part-time or full-time
    private String type;

    @ManyToOne
    private Company company;

    @Lob
    @Size(min = 1, max = 255)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String location;

    private String applyUrl;

    private String companyUrl;

    private String logoUrl;

}
