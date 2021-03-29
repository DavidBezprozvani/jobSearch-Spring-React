package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM Post p WHERE p.type = :type", nativeQuery = true)
    List<Post> findByType(@Param("type") Type type);


    @Query(value = "SELECT * FROM Post p WHERE p.company_id = :companyId", nativeQuery = true)
    List<Post> findByCompanyId(@Param("companyId") Long companyId);
}
