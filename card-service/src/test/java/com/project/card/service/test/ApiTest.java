package com.project.card.service.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class ApiTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/health")).andDo(print()).andExpect(status().isOk());
	}
}
