package kr.co.infStudy.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

	
	
	@Test
	public void test() throws Exception{
		
		
		standaloneSetup(new HomeController()).build()
			.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("index"));
	}

}
