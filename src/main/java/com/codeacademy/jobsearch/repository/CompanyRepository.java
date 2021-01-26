package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
