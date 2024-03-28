package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Post;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AllPostRepo extends JpaRepository<Post, Integer> {
    
    @Query("SELECT p FROM Post p WHERE p.user.user_id = :user_id")
    List<Post> findAllByUser(@Param("user_id") int user_id);

    @Query("SELECT p FROM Post p WHERE p.user.user_id != :user_id")
    List<Post> findAllByUserNot(@Param("user_id") int user_id);
}

