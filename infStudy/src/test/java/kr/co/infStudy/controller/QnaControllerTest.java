package kr.co.infStudy.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 이 어노테이션을 붙여줘야 스프링 테스트를 Junit으로 돌릴 수 있다.
@ContextConfiguration(locations = {"file:src/main/resources/spring/common-context.xml",
									"file:src/main/resources/spring/root-context.xml",
									"file:src/main/resources/servlet-context.xml"})
@WebAppConfiguration
@Slf4j
public class QnaControllerTest {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;

	protected MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void 질문_조회() throws Exception{
		mockMvc.perform(get("/course/{lecture_title}/questions", "testTitle1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn()
		.getModelAndView()
		.getModel();
	}

}


















