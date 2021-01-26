package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
