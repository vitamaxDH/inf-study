package kr.co.infStudy.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.infStudy.dto.home.HomeDTO;
import kr.co.infStudy.model.TestCkVO;
import kr.co.infStudy.service.HomeService;
import kr.co.infStudy.service.TestCkService;
@Controller
public class HomeController {

	@Autowired
	private TestCkService service; 
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(Model model, HttpServletRequest request) throws Exception {
//		model.addAttribute("testCkVO", new TestCkVO());
//		
//		
//		System.out.println(request.getSession());
//		
//		return "index";
//	}


//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(Model model) throws Exception {
//		log.info("메인 페이지");
//		model.addAttribute("testCkVO", new TestCkVO());
//		return "index";
//	}

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

	/********************************
	 * main page controller
	 ********************************************/
	@Autowired
	private HomeService homeService;

	@GetMapping(value = "/")
	public String home(Model model) throws Exception {

		ArrayList<HomeDTO> homeDto = homeService.getHomeList("date");
		ArrayList<HomeDTO> homeDto2 = homeService.getHomeList("rank");
		ArrayList<HomeDTO> homeDto3 = homeService.getHomeList("date_asc");

		model.addAttribute("homeDto", homeDto);
		model.addAttribute("homeDto2", homeDto2);
		model.addAttribute("homeDto3", homeDto3);
		return "home";
	}
	/*
	 * 나오는 데이터 값만 확인하기
	 * 
	 * @GetMapping(value = "/homeTest")
	 * 
	 * @ResponseBody public ArrayList<HomeDTO> homeTest(Model model) throws
	 * Exception {
	 * 
	 * ArrayList<HomeDTO> homeDto = homeService.getHomeList();
	 * 
	 * model.addAttribute("homeDto", homeDto); return homeDto; } >>>>>>> cj0515
	 */

}
