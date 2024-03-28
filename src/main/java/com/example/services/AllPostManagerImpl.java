package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Post;
import com.example.repository.AllPostRepo;

@Service
public class AllPostManagerImpl implements AllPostManager {

    @Autowired
    private AllPostRepo getall;

    @Override
    public List<Post> getAllPost() {
        return getall.findAll();
    } 

    @Override
    public List<Post> getMyPost(int user_id) {
        return getall.findAllByUser(user_id);
    }

    @Override
    public List<Post> getOtherPost(int user_id) {
        return getall.findAllByUserNot(user_id);
    }

    @Override
    public void addPost(Post post) {
        getall.save(post);
    }

    @Override
    public void deleteById(int post_id) {
        getall.deleteById(post_id);
    }

    @Override
    public void updateById(int post_id, Post post) {
        Post existingPost = getall.findById(post_id).orElse(null);
        if (existingPost != null) {
            existingPost.setPost(post.getPost());
            existingPost.setDate(post.getDate());
            // Update any other fields as needed
            getall.save(existingPost);
        }
    }

}
