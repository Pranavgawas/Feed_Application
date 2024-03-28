package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Post;
import com.example.services.AllPostManager;

@RestController
@CrossOrigin
public class AllPostController {
	@Autowired
	private AllPostManager allpostmgr;
	
	@GetMapping("api/getall")
	public List<Post> getAllPost(){
		return allpostmgr.getAllPost();
	}
	
	@GetMapping("api/mypost/{user_id}")
	public List<Post> getMyPost(@PathVariable int user_id){
		return allpostmgr.getMyPost(user_id);
	}
	
	@GetMapping("api/otherpost/{user_id}")
	public List<Post> getOtherPost(@PathVariable int user_id){
		return allpostmgr.getOtherPost(user_id);
	}
	
	@PostMapping("api/addpost")
	public void addPost(@RequestBody Post post) {
		allpostmgr.addPost(post);
	}

	@DeleteMapping("api/delete/{post_id}")
	public void deleteById(@PathVariable int post_id) {
		allpostmgr.deleteById(post_id);
	}
	
	@PostMapping("api/update/{post_id}")
	public void updateById(@PathVariable int post_id, @RequestBody Post post) {
		allpostmgr.updateById(post_id, post);
	}

}
