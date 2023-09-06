package com.project1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project1.Model.User;
import com.project1.repository.UserRepository;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
		
	@PostMapping("login")
	public ResponseEntity<?> LoginUser(@RequestBody User userData) {
		System.out.println(userData);
		User user= userRepository.findByUsername(userData.getUsername());
		 if(user.getPassword().equals(userData.getPassword()))
			 return ResponseEntity.ok(user);
		
		 return (ResponseEntity<?>) ResponseEntity.internalServerError();	  
	}
}
