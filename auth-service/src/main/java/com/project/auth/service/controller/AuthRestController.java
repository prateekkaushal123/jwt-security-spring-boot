package com.project.auth.service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.auth.service.entity.UserRequest;
import com.project.auth.service.util.JwtUtil;
import org.springframework.cloud.openfeign.EnableFeignClients;
@RestController
@EnableFeignClients
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserServiceProxy proxy;

	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody UserRequest req) {
		
		String email=req.getEmail();
		String password=req.getPassword();
		String token = jwtUtil.generateToken(email);
		String resp=proxy.login(req);
		
		if(resp.equals("true"))
			return new ResponseEntity<String>(token, HttpStatus.OK);
		
		return new ResponseEntity<String>("INVALID LOGIN", HttpStatus.OK);
	}

	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody String userName) {
		// Persist user to some persistent storage
		System.out.println("Info saved...");
		
		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}

}
