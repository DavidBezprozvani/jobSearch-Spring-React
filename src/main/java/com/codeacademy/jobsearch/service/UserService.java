package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(User user);

    User getUserEntityById(Long id);

    void deleteUser(Long id);

    UserDTO updateUser(UserDTO userDTO);
}
