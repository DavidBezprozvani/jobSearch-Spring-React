package com.codeacademy.jobsearch.entity.dto;

import com.codeacademy.jobsearch.entity.Role;
import com.codeacademy.jobsearch.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String name;

    private String password;

    @NotBlank
    private String surname;

    private String profilePictureUrl;

    private Set<String> roles;

    public UserDTO (User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.roles = user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
    }
}
