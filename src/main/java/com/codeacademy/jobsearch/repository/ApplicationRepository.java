package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
