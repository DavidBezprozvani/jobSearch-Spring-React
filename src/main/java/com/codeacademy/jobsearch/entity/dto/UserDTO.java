package com.codeacademy.jobsearch.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String profilePictureUrl;
}
