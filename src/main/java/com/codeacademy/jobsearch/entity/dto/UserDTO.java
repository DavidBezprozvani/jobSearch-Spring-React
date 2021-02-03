package com.codeacademy.jobsearch.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String profilePictureUrl;
}
