package kr.co.infStudy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.MyLecturesDTO;
import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaPageMaker;
import kr.co.infStudy.dto.qna.QnaSearchCriteria;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.service.LectureService;
import kr.co.infStudy.service.PaidLecService;
import kr.co.infStudy.service.QnaService;
import kr.co.infStudy.service.UsersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	private UsersService usersService;
	private LectureService lectureService;
	private PaidLecService paidLecService;
	private QnaService qnaService;
	private UsersVO usersVO;
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;

	
	@Autowired
	public UserController(UsersService usersService, LectureService lectureService, PaidLecService paidLecService, QnaService qnaService) throws Exception {
		this.usersService = usersService;
		this.lectureService = lectureService;
		this.paidLecService = paidLecService;
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
	
	@GetMapping(value = "/profile")
	public String profile(@ModelAttribute("update") UsersVO vo) throws Exception {
		
		return "user/profile";
	}
	
	

	@GetMapping(value = "/myLecture")
	public String myLecture(@RequestParam(required = false) String category_name,
							@RequestParam(required = false) String lecture_title,
							@RequestParam(required = false, defaultValue = "1") int page,
							Model model) throws Exception {

		
		ArrayList<MyLecturesDTO> myLectureList = lectureService.getMyLectureInfo(login.getU_no(), lecture_title, page);	
		model.addAttribute("pageBean", lectureService.getMyLectureCnt(login.getU_no(), page));
		
		
		model.addAttribute("myLectureList", myLectureList);
		
		return "myLecture";
	}
	
	@GetMapping("loginAfter")
	public String loginAfter() throws Exception {
		return "loginAfter";
	}

	@GetMapping(value = "/myQnA")
	public String myQnA(Model model, QnaSearchCriteria scri,
			  @RequestParam(name = "keyword", required = false) String keyword) throws Exception {

		//데이터 값 뽑아오기
		ArrayList<AllQnaDTO> myQnaDto = qnaService.getMyQnaList(login.getU_no(), keyword);
		model.addAttribute("myQnaDto", myQnaDto);
		
		
		if(keyword != null) {
			scri.setKeyword(keyword);
		}

		System.out.println(scri);
		
		//한 페이지의 시작번호와 끝 번호
		model.addAttribute("qnaList", qnaService.qnaList(scri));
		
		//페이지네이션
		QnaPageMaker qnaPageMaker = new QnaPageMaker();
		qnaPageMaker.setCri(scri);
		qnaPageMaker.setTotalCount(qnaService.qnaListCounts(scri));
		model.addAttribute("qnaPageMaker", qnaPageMaker);
		
		return "myQnA";
	}

	@PostMapping(value="updateNick")
	   public String updateNick(@ModelAttribute("update") UsersVO vo, Model model) throws Exception{
	      
	      vo.setEmail(login.getEmail());
	      model.addAttribute("update",vo);

	      if(vo.getEmail()!=null) {
	         usersService.updateNickname(vo);
	      }
	      
	      return "user/changeNick";
	   }
	   
	   @PostMapping(value="updatePassword")
	   public String updatePw(@ModelAttribute("update") UsersVO vo, Model model) throws Exception{
	      
	      vo.setEmail(login.getEmail());
	      model.addAttribute("update", vo);
	      System.out.println("비번변경에서의 model : " + model);
	      String password = DigestUtils.sha256Hex(vo.getPassword());
	      System.out.println("빨랑 암호화해!!!! "+password);
	      if(login.getPassword().equals(password)) {
	         usersService.updatePassword(vo);
	      
	         return "user/changePassword";
	      } else {
	         return "user/changeFail";
	      }
	      
	      
	   }

	/**
	 * 지식공유자되기 버튼 클릭 시 동작하는 핸들러. Instructor로 등록
	 */
	@GetMapping("/user/enrollInstructor")
	public String enrollInstructor() {
			
		usersService.enrollInstrunctor(login.getU_no());

		return "user/enrollInstructorSuccess";
	}
	
	/**
	 * 수강 신청
	 */
	@GetMapping("/user/addPaidLecture")
	public String addPaidLecture(@RequestParam(name = "l_no") int l_no,
								 @RequestParam(name = "lecture_title") String lecture_title) {
		
		paidLecService.addPaidLecture(l_no);
		
		return "redirect:/course/" + lecture_title;
	}
	
	/**
	 * 회원 탈퇴
	 */
       @GetMapping(value="byeUserForm")
	   public String byeUser(@ModelAttribute("byeUserVO")UsersVO byeUserVO) throws Exception{
		  return "user/byeUser";
	   }
	   
	   @PostMapping(value="byeUser")
	   public String byeUser(HttpSession session,@ModelAttribute("byeUserVO")UsersVO byeUserVO,Model model) throws Exception{
	      
	      model.addAttribute("byeUserVO", new UsersVO());
	      
	      usersService.byeUser(byeUserVO);
	      
	   
	      session.invalidate();

	      
	      return "user/byeUserSuccess";
	   }


}
















