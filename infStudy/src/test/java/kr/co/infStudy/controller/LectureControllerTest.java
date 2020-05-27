package kr.co.infStudy.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 이 어노테이션을 붙여줘야 스프링 테스트를 Junit으로 돌릴 수 있다.
@ContextConfiguration(locations = {"file:src/main/resources/spring/common-context.xml",
									"file:src/main/resources/spring/root-context.xml",
									"file:src/main/resources/servlet-context.xml"})
@WebAppConfiguration
@Slf4j
public class LectureControllerTest {


	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;

	protected MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void 강의_전체_조회() throws Exception {
		
		mockMvc.perform(get("/courses?page=2"))
				.andDo(print())
				.andReturn()
				.getModelAndView()
				.getModelMap();
	}
	
	@Test 
	public void 커리큘럼_추가하기() throws Exception{
		mockMvc.perform(get("/course/{lecture_title}/addCurriculum/{l_no}", "testTitle1", "1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn()
				.getModelAndView()
				.getModel();
	}
	
	@Test
	public void 강의등록() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/course/{lecture_title}/addCurriculum", "testTitle1")
									.param("l_no", "1")
									.param("section", "999")
									.param("title", "강의넣기 테스트 코드")
									.param("url", "강의넣기 테스트 url 파라미터")
									.param("playtime","10000"))
								.andDo(print())
								.andReturn()
								.getModelAndView()
								.getViewName();
							
		log.info(result);
				
	}

}















