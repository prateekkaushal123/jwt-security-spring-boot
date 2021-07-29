package com.project.auth.service.controller;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.auth.service.entity.UserRequest;

@FeignClient(name = "USER-SERVICE", url = "localhost:9050")
public interface UserServiceProxy {
	
	@GetMapping("/login")
	public String login(@SpringQueryMap UserRequest req);
}
