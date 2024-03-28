package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.entities.Post;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AllPostRepo extends JpaRepository<Post, Integer> {
    
    @Query("SELECT p FROM Post p WHERE p.user.user_id = :user_id")
    List<Post> findAllByUser(@Param("user_id") int user_id);

    @Query("SELECT p FROM Post p WHERE p.user.user_id <> :user_id AND p.approved = true")
    List<Post> findAllByUserNotAndApproved(@Param("user_id") int user_id);

    @Query("SELECT p FROM Post p WHERE p.approved = false")
    List<Post> getUnApprovedPost();

    @Modifying
    @Query("UPDATE Post p SET p.approved = true WHERE p.id = :postId")
    void approvePost(@Param("postId") Long postId);

    @Modifying
    @Query("UPDATE Post p SET p.post = :post WHERE p.id = :postId")
    void updateMyPost(@Param("postId") int postId, @Param("post") String post);

    @Modifying
    @Query(value = "INSERT INTO Post (approved, date, post, user_id) VALUES (false, CURRENT_TIMESTAMP, :post, :user_id)", nativeQuery = true)
    void addMyPost(@Param("post") String post, @Param("user_id") int user_id);




}

 