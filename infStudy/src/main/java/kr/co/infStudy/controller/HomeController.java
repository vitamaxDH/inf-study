package kr.co.infStudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.infStudy.model.TestCkVO;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.service.TestCkService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private TestCkService service; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws Exception {
		log.info("메인 페이지");
		model.addAttribute("testCkVO", new TestCkVO());
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) throws Exception {
		log.info("테스트 페이지");
		
		model.addAttribute("testCkVO", new TestCkVO());
		return "test";
	}
	
	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
	public String testSave(@ModelAttribute TestCkVO vo)throws Exception {
		log.info("testSave");
		service.testSave(vo);
		return "redirect:test";
	}
	
	@GetMapping("/testShow")
	public String testShow(@RequestParam int id, Model model) throws Exception {
		log.info("testShow");
		
		model.addAttribute("testCkVO", service.getVO(id));
		
		return "content";
	}
	
//	ddddd
	//aaa
	
}
