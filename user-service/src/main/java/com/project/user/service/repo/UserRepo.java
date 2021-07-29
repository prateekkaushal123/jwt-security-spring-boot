package com.project.user.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.user.service.entity.User;

public interface UserRepo extends MongoRepository<User, String> {
	
	@Query(value = "{'email':?0}")
	public User getUser(String email);
}