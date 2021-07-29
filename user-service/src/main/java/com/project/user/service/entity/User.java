package com.project.user.service.entity;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	public User(UserRequest userRequest) {
		this.name = userRequest.getName();
		this.email = userRequest.getEmail();
		this.createdAt = new Date();
	}
	
	@Id
	private String id;
	
	private String name;
	private String email;
	private Date createdAt;
}