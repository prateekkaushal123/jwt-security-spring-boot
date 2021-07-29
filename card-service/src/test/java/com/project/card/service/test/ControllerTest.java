package com.project.card.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.card.service.controller.CardController;

@SpringBootTest
class ControllerTest {
	@Autowired
	CardController homeController;
	
	@Test
    void testHomeController() {
        String result = homeController.respond();
        assertEquals("Hello from card service. Service is up", result);
    }	
}
