package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.service.impl.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public UserDTO user(@AuthenticationPrincipal User user) {
//        return userService.getUserDtoByUser(user);
        return new UserDTO(user);
    }
}
