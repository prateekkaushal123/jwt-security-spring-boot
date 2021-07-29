package com.project.user.service.controller;

import java.util.List;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.service.entity.User;
import com.project.user.service.entity.UserRequest;
import com.project.user.service.services.UserService;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping("/health")
	public String respond() {
		MDC.put("user.name", "null");
		log.info("User Service /health called.");
		return "Hello from User Service";
		//System.out.print("***********************hello from user-service");
		//return "false"; 
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		//return null;
		return service.getAllUsers(); 
	}
	
	@PostMapping("/insertOne")
	public User insertUser(@RequestBody UserRequest userRequest) {
		return service.saveUser(new User(userRequest)); 
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		User user=new User();
		user.setEmail(email);
		user.setName(password);
		User test=service.getUser(user);
		
		//System.out.println("********************************"+test);
		if(test==null)
			return "false";
		if(test.getEmail().equals(email))
			return "true";
		//if(email.equals("a@b.c") && password.equals("1234"))
			//return "true";
		return "false";
		//return service.saveUser(new User(userRequest)); 
	}
	
	@GetMapping("/login2")
	public User login2(@RequestParam("email") String email,@RequestParam("password") String password) {
		User user=new User();
		user.setEmail(email);
		user.setName(password);
		User test=service.getUser(user);
		
		return test;
		//return service.saveUser(new User(userRequest)); 
	}
	
}
