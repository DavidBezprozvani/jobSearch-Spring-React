package com.codeacademy.jobsearch.repository;

import com.codeacademy.jobsearch.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //TODO: fix me
//    @Query(value = "SELECT * FROM Post p WHERE p.type = :type", nativeQuery = true)
//    List<Post> findByType(@Param("type") String type);


    @Query(value = "SELECT * FROM Post p WHERE p.company_id = :companyId", nativeQuery = true)
    List<Post> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT * FROM Post p WHERE p.location = :location", nativeQuery = true)
    List<Post> findByType(@Param("location") String location);

}
