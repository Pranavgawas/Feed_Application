package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager{
	@Autowired
	private UserRepository userRepo;

	@Override
	public void Register(User user) {
		userRepo.save(user);
		
	}

	@Override
	public boolean validateUser(User user) {
		return userRepo.validateUser(user.getUsername(), user.getPassword());
	}

//	@Override
//	public boolean isAdminOrNot(User user) {
//		// TODO Auto-generated method stub
//		return userRepo.isAdmin(user.getUser_id(),user.getRole());
//	}
 
//    @Override
//    public User findByUsername(String username) {
//        Optional<User> userOptional = userRepo.findByUsername(username);
//        return userOptional.orElse(null); 
//    }

}
