package kr.co.infStudy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.infStudy.model.TestCkVO;
import kr.co.infStudy.service.TestCkService;
import lombok.extern.slf4j.Slf4j;
@Controller
public class HomeController {
	
	@Autowired
	private TestCkService service; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("testCkVO", new TestCkVO());
		
		
		System.out.println(request.getSession());
		
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) throws Exception {
		
		model.addAttribute("testCkVO", new TestCkVO());
		return "test";
	}
	
	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
	public String testSave(@ModelAttribute TestCkVO vo)throws Exception {
		service.testSave(vo);
		return "redirect:test";
	}
	
	@GetMapping("/testShow")
	public String testShow(@RequestParam int id, Model model) throws Exception {
		
		model.addAttribute("testCkVO", service.getVO(id));
		
		return "content";
	}
	
//	ddddd
	//aaa
//	ccc
	//xx

	
}
