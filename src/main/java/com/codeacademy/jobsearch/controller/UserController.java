package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServiceImpl userServiceImpl;
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody @Valid User user) {
        return userServiceImpl.createUser(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public List<UserDTO> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public UserDTO getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    // TODO: get by users name, update user

}
