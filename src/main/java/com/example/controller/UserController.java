package com.example.controller;
 
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.entities.AuthRequest;
import com.example.entities.User;
//import com.example.services.JwtService;
import com.example.services.UserManager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserManager userManager;
	 
//    @Autowired
//    private JwtService jwtService; 
//  
//    @Autowired
//    private AuthenticationManager authenticationManager; 
	
	@PostMapping(value="api/Registration")
	public void Register(@RequestBody User user) {
		userManager.Register(user);
	}
	
	@PostMapping(value="api/login")
    public boolean validateUser(@RequestBody User user) {
		return userManager.validateUser(user);
    }	
	
	@GetMapping(value = "api/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
    @PostMapping(value="/api/login/isAdmin")
    public boolean checkAdmin(@RequestBody User user) {
        if (userManager.validateAdmin(user)) {
            return true;
        } else { 
            return false;
        }
    }
    
    @GetMapping(value="/api/user/getuserid/{username}")
    public Long getUserIdByUsername(@PathVariable String username) {
        return userManager.getUserIdByUsername(username);
    }

	
//	@GetMapping("api/current-user")
//	public ResponseEntity<Integer> getCurrentUserId(HttpServletRequest request) {
//	    HttpSession session = request.getSession(false);
//	    if (session != null) {
//	        User user = (User) session.getAttribute("currentUser");
//	        if (user != null) {
//	            return ResponseEntity.ok(user.getUser_id());
//	        }
//	    }
//	    return ResponseEntity.notFound().build();
//	}

	
//    @GetMapping("/user/userProfile") 
//    @PreAuthorize("hasAuthority('ROLE_USER')") 
//    public String userProfile() { 
//        return "Welcome to User Profile"; 
//    } 
//  
//    @GetMapping("/admin/adminProfile") 
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
//    public String adminProfile() { 
//        return "Welcome to Admin Profile"; 
//    } 
//  
//    @PostMapping("/generateToken") 
//    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
//        if (authentication.isAuthenticated()) { 
//            return jwtService.generateToken(authRequest.getUsername()); 
//        } else { 
//            throw new UsernameNotFoundException("invalid user request !"); 
//        } 
//    } 
  
}
