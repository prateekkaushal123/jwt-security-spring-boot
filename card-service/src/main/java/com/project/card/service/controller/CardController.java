package com.project.card.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class CardController {

	@GetMapping("/health")
	public String respond() {
		log.info("Card Service /health endpoint called");
		return "Hello from card service. Service is up"; 
	}
}
