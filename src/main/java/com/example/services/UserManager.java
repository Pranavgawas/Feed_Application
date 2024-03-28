package com.example.services;

import com.example.entities.User;

public interface UserManager {
	public void Register(User user);
	public boolean validateUser(User user);
//	public User findByUsername(String username);
//	public boolean isAdminOrNot(User user);
}
