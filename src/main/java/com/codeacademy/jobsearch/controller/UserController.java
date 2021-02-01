package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.service.UserService;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // TODO: get by users name, update user

}
