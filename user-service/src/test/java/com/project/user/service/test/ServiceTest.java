package com.project.user.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.user.service.entity.User;
import com.project.user.service.entity.UserRequest;
import com.project.user.service.repo.UserRepo;
import com.project.user.service.services.UserService;

@SpringBootTest
class ServiceTest {	
	@MockBean
	private UserRepo repo;
	
	@Autowired
	UserService service;
	
	@Test
	void testGetAllController() {
		List<User> users = new ArrayList<>();
		users.add(new User("123", "Deepanjan", "deep@gmail.com", new Date()));
		users.add(new User("124", "Datta", "datta@yahoo.com", new Date()));
		
		when(repo.findAll()).thenReturn(users);
		
		List<User> usersReturned = service.getAllUsers();
        assertEquals(users, usersReturned);
	}
	
	@Test
	void testInsertUserController() {
		UserRequest userRequest = new UserRequest("Deepanjan Datta", "deep@gmail.com");
		User user = new User(userRequest);
		
		when(repo.save(user)).thenReturn(user);
		
		User userReturned = service.saveUser(user);
        assertEquals(user, userReturned);
	}
}
