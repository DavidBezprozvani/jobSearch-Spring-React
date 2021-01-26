package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.JobAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdRepository extends JpaRepository<JobAd, Long> {
}
