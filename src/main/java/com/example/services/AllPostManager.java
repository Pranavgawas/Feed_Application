package com.example.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.entities.Post;

public interface AllPostManager {
    List<Post> getAllPost();
    List<Post> getMyPost(int user_id);
    List<Post> getOtherPost(int user_id);
    void addPost(String post, int user_id);
    void deleteById(int post_id);
    void updateById(int post_id, String myPost);
	void approvePost(Long postId);
}
