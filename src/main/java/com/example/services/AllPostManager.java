package com.example.services;

import java.util.List;

import com.example.entities.Post;

public interface AllPostManager {
    List<Post> getAllPost();
    List<Post> getMyPost(int user_id);
    List<Post> getOtherPost(int user_id);
    void addPost(Post post);
    void deleteById(int post_id);
    void updateById(int post_id, Post post);
}
