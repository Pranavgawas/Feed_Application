package com.example.services;

import java.util.Optional;

import com.example.entities.User;

public interface UserManager {
	public void Register(User user);
	public boolean validateAdmin(User user);
	public Long getUserIdByUsername(String username);
	boolean validateUser(User user);
}
