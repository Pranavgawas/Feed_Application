package com.example.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Post;
import com.example.services.AllPostManager;

@RestController
@CrossOrigin
public class AllPostController {
	@Autowired
	private AllPostManager allpostmgr;
	
	@GetMapping("api/user/getallUnApprovedPost")
	public List<Post> getAllPost(){
		return allpostmgr.getAllPost();
	}
	 
	@PutMapping("/api/user/approve/{postId}")
	public ResponseEntity<String> approvePost(@PathVariable Long postId) {
	    try {
	        allpostmgr.approvePost(postId);
	        return ResponseEntity.ok("Post approved successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to approve post: " + e.getMessage());
	    }
	}

	
	@GetMapping("api/user/mypost/{user_id}")
	public List<Post> getMyPost(@PathVariable int user_id){
		return allpostmgr.getMyPost(user_id);
	}
	
	@GetMapping("api/user/otherpost/{user_id}")
	public List<Post> getOtherPost(@PathVariable int user_id){
		return allpostmgr.getOtherPost(user_id);
	}
	
	@PostMapping("api/addpost/{user_id}")
	public void addPost(@RequestBody String post, @PathVariable int user_id) {
		allpostmgr.addPost(post, user_id);
	} 

	@DeleteMapping("api/user/delete/{post_id}")
	public void deleteById(@PathVariable int post_id) {
		allpostmgr.deleteById(post_id);
	}
	
	@PutMapping("api/user/update/{post_id}")
	public void updateById(@PathVariable int post_id, @RequestBody String myPost) {
		
		allpostmgr.updateById(post_id, myPost);
	}
	
	
	

}
