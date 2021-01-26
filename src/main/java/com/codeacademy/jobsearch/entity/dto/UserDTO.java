package com.codeacademy.jobsearch.entity.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 3)
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String profilePictureUrl;
}
