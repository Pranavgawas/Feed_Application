package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager{
	
	@Autowired
    private UserRepository userRepository;

    @Override
    public void Register(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean validateUser(User user) {
        return userRepository.validateUser(user.getUsername(), user.getPassword());
    }

	@Override
	public boolean validateAdmin(User user) {
		// TODO Auto-generated method stub
		 return userRepository.validateAdmin(user.getUsername(), user.getPassword());
	}


	@Override
	public Long getUserIdByUsername(String username) {
	    return userRepository.getUserIdByUsername(username);
	}



}
 