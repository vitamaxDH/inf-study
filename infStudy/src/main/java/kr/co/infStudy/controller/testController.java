package kr.co.infStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

	
	@GetMapping(value = "/abac", produces = "text/html;charset=utf8")
	@ResponseBody
	public String abc() {
		
		return "한글 깨짐??aaaa";
	}
}
	