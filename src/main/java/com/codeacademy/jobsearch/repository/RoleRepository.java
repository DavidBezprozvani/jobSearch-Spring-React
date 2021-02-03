package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
