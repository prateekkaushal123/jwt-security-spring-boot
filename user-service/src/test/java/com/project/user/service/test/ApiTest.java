package com.project.user.service.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.project.user.service.entity.UserRequest;

@AutoConfigureMockMvc
@SpringBootTest
class ApiTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void healthCheckTest() throws Exception {
		this.mockMvc.perform(get("/health")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void getAllUsersTest() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}
}
