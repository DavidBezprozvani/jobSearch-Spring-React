package com.codeacademy.jobsearch.service.impl;

import com.codeacademy.jobsearch.entity.Role;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.RoleRepository;
import com.codeacademy.jobsearch.repository.UserRepository;
import com.codeacademy.jobsearch.service.UserService;
import com.codeacademy.jobsearch.service.mapper.EntityMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;
    private EntityMapper entityMapper;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, EntityMapper entityMapper, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> entityMapper.convertUserEntityToDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return entityMapper.convertUserEntityToDTO(getUserEntityById(id));
    }

    @Override
    public UserDTO createUser(User user){
        Role role = roleRepository.getOne(2L);
        user.addRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return entityMapper.convertUserEntityToDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Long id = userDTO.getId();
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        User user = userRepository.getOne(id);
        user.setProfilePictureUrl(userDTO.getProfilePictureUrl());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(user);
        return entityMapper.convertUserEntityToDTO(updatedUser);
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public User getUserEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
