package kr.co.infStudy.controller;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.lecture.AddCurriculumDTO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;
import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.CurriculumVO;
import kr.co.infStudy.model.ReviewVO;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.pageBean.PageBean;
import kr.co.infStudy.service.CurriculumService;
import kr.co.infStudy.service.LectureService;
import kr.co.infStudy.service.ReviewService;
import lombok.RequiredArgsConstructor;
/**
 * 
 * @author hydes
 * 강의와 관련된 Controller로
 * 강의 조회, 강의 상세 조회, 강의 등록에 대한 Handler가 있다.
 */
@Controller
@RequiredArgsConstructor
public class LectureController {
	
	private final LectureService lectureService;
	private final CurriculumService curriculumService;
	private final ReviewService reviewService;
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;
	
	/**
	 * 
	 * @param request 
	 * @param category_name 해당 카테고리의 강의를 보여주기 위한 파라미터
	 * @param order 강의 정렬 순서를 정하기 위한 파라미터
	 * @param page pagination을 위한 파라미터
	 * @param model 객체는 view단에 넘겨주기 위한 Model 객체
	 * @return
	 * 
	 * 강의 조회에 대한 핸들러
	 * 
	 */
	@GetMapping(value = "/courses", produces = "application/json; charset=utf-8")
	public String getLectureInfo(@RequestParam(required = false) String category_name,
								 @RequestParam(required = false) String lecture_title,
								 @RequestParam(required = false, defaultValue = "price") String order,
								 @RequestParam(required = false, defaultValue = "1") int page,
								 Model model) {
		
		
		System.out.println(lecture_title);
		ArrayList<LectureDTO> lectureList = lectureService.getLectureInfo(category_name, order, lecture_title, page);
		
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("category_name", category_name);		
		model.addAttribute("pageBean", lectureService.getLectureCnt(category_name, page));
		
		System.out.println(lectureList);
		
		return "course/courseList";
	}
	
	/**
	 * 
	 * @param lecture_title 강의 상세 조회를 위한 강의 제목
	 * @return
	 * @throws Exception
	 * 강의 상세 조회를 위한 핸들러
	 */
	@GetMapping(value = "/course/{lecture_title}")
	public String getLectureDetail(@PathVariable String lecture_title,
								   @ModelAttribute("review") ReviewVO review,
								   Model model) throws Exception{
		
		ArrayList<LectureReviewDTO> lectureReview = (ArrayList<LectureReviewDTO>) reviewService.getLectureReviews(lecture_title);
		int[] rankAvg = {0, 0, 0, 0, 0};
		lectureReview.stream().map(o->{return o.getRank();}).forEach(o->{rankAvg[5-o]++;});
		
		model.addAttribute("curriculum_list", curriculumService.getCurriculumList(lecture_title));
		model.addAttribute("lectureReview", lectureReview);
		model.addAttribute("lectureDetail", lectureService.getLectureDetail(lecture_title));
		model.addAttribute("auth", login.getAuth());			
		model.addAttribute("rankAvg", rankAvg);
		
		return "course/courseDetail";
	}
	
	/**
	 * 
	 * @param addLecture 강의 등록 시 해당 강의에 대한 입력 정보를 전달하는 DTO
	 * @return
	 * 강의 추가를 위한 핸들러
	 */
	@GetMapping("/course/gotoAddLecturePg")
	public String addLecturepg(@ModelAttribute("addLecture") UploadLectureDTO addLecture) {
		
		
		return "course/addLecturePg";
	}
	
	@PostMapping("/course/addLecture")
	public String addLecture(@ModelAttribute("addLecture") UploadLectureDTO addLecture) {

		lectureService.addLecture(addLecture);
		
		return "course/addLectureSuccess";
	}
	
	/**
	 * 
	 * @param lecture_title 강좌 이름
	 * @param c_no 강좌 내의 강의 번호
	 * @param model
	 * @return
	 * 
	 * 강의 실행 페이지로 이동시키는 핸들러
	 */
	//lecture 뒤에 PathVariable로 curriculum No 받아오기
	@GetMapping("/course/{lecture_title}/lecture/{c_no}")
	public String lecturePlay(@PathVariable String lecture_title,
							  @PathVariable int c_no,
							  Model model) {
		
		ArrayList<LecturesCurriculumDTO> curriculum_list = (ArrayList<LecturesCurriculumDTO>) curriculumService.getCurriculumList(lecture_title);
		model.addAttribute("curriculum_list", curriculum_list);
		model.addAttribute("lecture_title", lecture_title);
		model.addAttribute("c_no", c_no);

		for(int i=0;i<curriculum_list.size();i++) {
			if(curriculum_list.get(i).getC_no() == c_no) {
				model.addAttribute("url", curriculum_list.get(i).getUrl());
				break;
			}
		}
				
		return "course/lecturePlay";
	}
	
	@GetMapping(value = "/course/{lecture_title}/addCurriculum/{l_no}")
	public String gotoAddCurriculumPg(@PathVariable String lecture_title,
									  @PathVariable int l_no,
									  @ModelAttribute(name = "addCurriculumVO") CurriculumVO addCurriculumVO,
									  Model model){
		
		model.addAttribute("l_no", l_no);
		model.addAttribute("lecture_title", lecture_title);
		model.addAttribute("sectionList", curriculumService.getSectionList(l_no));
		
		return "course/addCurriculumPg";
	}
	
	@PostMapping(value="/course/{lecture_title}/addCurriculum")
	public String addCurriculum(@ModelAttribute(name = "addCurriculumVO") CurriculumVO addCurriculumVO,
								@PathVariable String lecture_title,
								Model model) {
		
		System.out.println(addCurriculumVO);
		
		curriculumService.addCurriculum(addCurriculumVO);
		model.addAttribute("lecture_title", lecture_title);
		
		return "course/addCurriculumSuccess";
	}
	
	@GetMapping(value="/lecture/chkTitle/{lecture_title}")
	@ResponseBody
	public String chkTitle(@PathVariable("lecture_title") String lecture_title) {
		 
		return lectureService.chkTitle(lecture_title);
	}
}





















