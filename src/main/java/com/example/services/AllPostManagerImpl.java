package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entities.Post;
import com.example.entities.User;
import com.example.repository.AllPostRepo;
import com.example.repository.UserRepository;

@Service
public class AllPostManagerImpl implements AllPostManager {

    @Autowired
    private AllPostRepo getall;
    


    @Override
    public List<Post> getAllPost() {
        return getall.getUnApprovedPost();
    } 

    @Override
    public List<Post> getMyPost(int user_id) {
        return getall.findAllByUser(user_id);
    }

    @Override
    public List<Post> getOtherPost(int user_id) {
        return getall.findAllByUserNotAndApproved(user_id);
    }

    @Override
    public void addPost(String post, int user_id) {
        getall.addMyPost(post, user_id);
    }


    @Override
    public void deleteById(int post_id) {
        getall.deleteById(post_id);
    }

    @Override
    public void updateById(int post_id, String post) {
        getall.updateMyPost(post_id, post);
    }
 
    @Override
    public void approvePost(Long postId) {
    	getall.approvePost(postId);
    }

}
