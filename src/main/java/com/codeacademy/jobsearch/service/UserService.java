package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Role;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.UserRepository;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private EntityToDtoMapper entityMapper;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, EntityToDtoMapper entityMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
        this.passwordEncoder = passwordEncoder;
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


    public UserDTO addUser(User user){
        User savedUser = userRepository.save(user);
        savedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        savedUser.setRoles(Set.of(new Role(2L, "USER")));
        return entityMapper.convertUserEntityToDTO(savedUser);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // TODO: get by users name, update user


    public User getUserEntityById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public UserDTO getUserDtoByUser(User user) {
        return entityMapper.convertUserEntityToDTO(user);
    }
}
