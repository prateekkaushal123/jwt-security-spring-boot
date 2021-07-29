package com.project.product.service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class ProductController {

	@GetMapping("/health")
	public String respond() {
		log.info("Product controller /health called");
		return "Hello from product service. Service is up"; 
	}
	@GetMapping("/product")
	public ResponseEntity<String> echo( ) {
		return new ResponseEntity<String>("All products selected ", HttpStatus.OK);
	}
	@GetMapping("/product/{msg}")
	public ResponseEntity<String> echo2(@PathVariable String msg) {
		return new ResponseEntity<String>("Product selected: , "+msg, HttpStatus.OK);
	}
}
