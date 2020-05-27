package kr.co.infStudy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
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
	public String getLectureInfo(HttpServletRequest request,
												@RequestParam(required = false) String category_name,
												@RequestParam(required = false) String lecture_title,
												@RequestParam(required = false, defaultValue = "price") String order,
												@RequestParam(required = false, defaultValue = "1") int page,
												Model model) {
		
		
		System.out.println(lecture_title);
		ArrayList<LectureDTO> lectureList = lectureService.getLectureInfo(category_name, order, lecture_title, page);
		
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("category_name", category_name);		
		model.addAttribute("pageBean", lectureService.getLectureCnt(category_name, page));
		
		return "course/courseList";
	}
	
	/**
	 * 
	 * @param lecture_title 강의 상세 조회를 위한 강의 제목
	 * @return
	 * @throws Exception
	 * 강의 상세 조회를 위한 핸들러
	 */
	@GetMapping(value = "/course/{lecture_title}", produces = "application/json; charset=utf-8")
	public String getLectureDetail(@PathVariable String lecture_title,
								   Model model) throws Exception{
		
		model.addAttribute("lectureDetail", lectureService.getLectureDetail(lecture_title));
		model.addAttribute("curriculum_list", curriculumService.getCurriculumList(lecture_title));
		model.addAttribute("lectureReview", reviewService.getLectureReviews(lecture_title));
		
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
		
		model.addAttribute("curriculum_list", curriculumService.getCurriculumList(lecture_title));
		model.addAttribute("lecture_title", lecture_title);
		model.addAttribute("c_no", c_no);
		
		return "course/lecturePlay";
	}
}





















