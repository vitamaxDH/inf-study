package kr.co.infStudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.service.PaidLecService;
import kr.co.infStudy.service.UsersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	private UsersService usersService;
	private PaidLecService padiLecService;

	@Autowired
	public UserController(UsersService usersService, PaidLecService padiLecService) {
		this.usersService = usersService;
		this.padiLecService = padiLecService;
	}

	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UsersVO usersVO = usersService.selectUser(1);
		session.setAttribute("usersVO", usersVO);
		return "user/dashboard";
	}

	@GetMapping(value = "my-courses")
	public String myCourses(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		UsersVO usersVO = (UsersVO) session.getAttribute("usersVO");
		List<MyCoursesDTO> myCoursesList = usersService.getMyCoursesList(usersVO);
		model.addAttribute("myCoursesList", myCoursesList);
		return "user/my-courses";
	}

	@GetMapping(value = "my-questions")
	public String myQuestions() {
		return "user/my-questions";
	};
	
	@GetMapping(value = "wishList")
	public String wishList() {
		return "user/wishList";
	};

	@GetMapping(value = "paidLecList")
	public String paidLecList() {
		return "user/paidLecList";
	};

	@GetMapping(value = "setting")
	public String setting() {
		return "user/setting";
	};


}
