package kr.co.infStudy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.service.PaidLecService;
import kr.co.infStudy.service.QnaService;
import kr.co.infStudy.service.UsersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	private UsersService usersService;
	private PaidLecService padiLecService;
	private QnaService qnaService;
	private UsersVO usersVO;
	private HttpSession session;
	
	@Autowired
	public UserController(UsersService usersService, PaidLecService padiLecService, QnaService qnaService) throws Exception {
		this.usersService = usersService;
		this.padiLecService = padiLecService;
		this.qnaService = qnaService;
	}

	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request, Model model) throws Exception {
		Map<String, String> bigTitle = new HashMap<String, String>();
		bigTitle.put("title", "대쉬보드");
		bigTitle.put("path", "/dashboard");
		
		
		
		
		model.addAttribute("bigTitle",bigTitle);
		return "user/dashboard";
	}

	@GetMapping(value = "my-courses")
	public String myCourses(HttpServletRequest request, Model model) throws Exception {
		Map<String, String> bigTitle = new HashMap<String, String>();
		Map<String, String> smTitle = new HashMap<String, String>();
		bigTitle.put("title", "내 학습");
		bigTitle.put("path", "/my-courses");
		smTitle.put("title", "수강중인 강의");
		smTitle.put("path", "/my-courses");
		
			
		
		
		model.addAttribute("bigTitle",bigTitle);
		return "user/my-courses";
	}

	@GetMapping(value = "my-questions")
	public String myQuestions(Model model) {
		Map<String, String> bigTitle = new HashMap<String, String>();
		Map<String, String> smTitle = new HashMap<String, String>();
		bigTitle.put("title", "내 학습");
		bigTitle.put("path", "/my-courses");
		smTitle.put("title", "내 질문");
		smTitle.put("path", "/my-questions");
		
		
		
		
		
		model.addAttribute("bigTitle",bigTitle);
		model.addAttribute("smTitle",smTitle);
		return "user/my-questions";
	};
	
	@GetMapping(value = "wishList")
	public String wishList(Model model) {
		Map<String, String> bigTitle = new HashMap<String, String>();
		Map<String, String> smTitle = new HashMap<String, String>();

		bigTitle.put("title", "내 결제");
		bigTitle.put("path", "/wishList");
		smTitle.put("smTitle", "위시리스트");
		smTitle.put("path", "/wishList");
		model.addAttribute("bigTitle",bigTitle);
		model.addAttribute("smTitle",smTitle);
		return "user/wishList";
	};

	@GetMapping(value = "paidLecList")
	public String paidLecList(Model model) {
		Map<String, String> bigTitle = new HashMap<String, String>();
		Map<String, String> smTitle = new HashMap<String, String>();
		bigTitle.put("title", "내 결제");
		bigTitle.put("path", "/wishList");
		smTitle.put("title", "구매 내역");
		smTitle.put("path", "/paidLecList");
		model.addAttribute("bigTitle",bigTitle);
		model.addAttribute("smTitle",smTitle);
		return "user/paidLecList";
	};

	@GetMapping(value = "setting")
	public String setting(Model model) {
		Map<String, String> bigTitle = new HashMap<String, String>();
		bigTitle.put("title", "설정");
		bigTitle.put("path", "/setting");
		model.addAttribute("bigTitle",bigTitle);
		return "user/setting";
	};


}
