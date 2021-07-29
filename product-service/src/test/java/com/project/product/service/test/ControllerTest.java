package com.project.product.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.product.service.controller.ProductController;

@SpringBootTest
class ControllerTest {
	@Autowired
	ProductController homeController;
	
	@Test
    void testHomeController() {
        String result = homeController.respond();
        assertEquals("Hello from product service. Service is up",result);
    }	
}
