package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserServiceImpl userServiceImpl;

    public UserRegistrationController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody @Valid User user) {
        return userServiceImpl.createUser(user);
    }

}
