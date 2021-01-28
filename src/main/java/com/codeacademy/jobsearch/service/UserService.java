package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.UserRepository;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private EntityToDtoMapper entityMapper;

    public UserService(UserRepository userRepository, EntityToDtoMapper entityMapper) {
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }


    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> entityMapper.convertUserEntityToDTO(user))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id){
        return entityMapper.convertUserEntityToDTO(getUserEntityById(id));
    }


    public User addUser(User user){
        return userRepository.save(user);
    }


    // TODO: get by users name, update user

    public User getUserEntityById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
