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

import com.project.user.service.controller.UserController;
import com.project.user.service.entity.User;
import com.project.user.service.entity.UserRequest;
import com.project.user.service.services.UserService;

@SpringBootTest
class ControllerTest {		
	@MockBean
	UserService service;
	
	@Autowired
	UserController controller;
	
	@Test
    void testHealthController() {
        String result = controller.respond();
        assertEquals("Hello from user service. Service is up", result);
    }	
	
	@Test
	void testGetAllController() {
		List<User> users = new ArrayList<>();
		users.add(new User("123", "Deepanjan", "deep@gmail.com", new Date()));
		users.add(new User("124", "Datta", "datta@yahoo.com", new Date()));
		
		when(service.getAllUsers()).thenReturn(users);
		
		List<User> usersReturned = controller.getAllUsers();
        assertEquals(users, usersReturned);
	}
}
