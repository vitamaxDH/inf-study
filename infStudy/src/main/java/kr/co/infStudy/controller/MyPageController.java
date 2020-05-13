package kr.co.infStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
	
	@GetMapping(value = "my-courses")
	public String myCourses() throws Exception {
		
		return null;
	}
}
