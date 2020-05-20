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
import kr.co.infStudy.service.CurriculumService;
import kr.co.infStudy.service.LectureService;
import kr.co.infStudy.service.ReviewService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LectureController {
	
	private final LectureService lectureService;
	private final CurriculumService curriculumService;
	private final ReviewService reviewService;
	
	
	@GetMapping(value = "/courses", produces = "application/json; charset=utf-8")
	public String getLectureInfo(HttpServletRequest request,
												@RequestParam(required = false) String category_name,
												@RequestParam(required = false, defaultValue = "price") String order,
												Model model) {
		
		request.getSession().setAttribute("login", new UsersVO(1, "aaa@aaa.aaa", "aaaaaa", "aaaaaa", "aaaaaa"));
		
		ArrayList<LectureDTO> lectureList = lectureService.getLectureInfo(category_name, order);
		
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("category_name", category_name);
		
		System.out.println(request.getServletContext().getRealPath("/"));
		
		return "course/courseList";
	}
	
	@GetMapping(value = "/course/{lecture_title}", produces = "application/json; charset=utf-8")
	public String getLectureDetail(@PathVariable String lecture_title, Model model) throws Exception{
		
		model.addAttribute("lectureDetail", lectureService.getLectureDetail(lecture_title));
		model.addAttribute("curriculum_list", curriculumService.getCurriculumList(lecture_title));
		model.addAttribute("lectureReview", reviewService.getLectureReviews(lecture_title));
		
		return "course/courseDetail";
	}
	
	@GetMapping("/course/gotoAddLecturePg")
	public String addLecturepg(@ModelAttribute("addLecture") UploadLectureDTO addLecture) {
		
		
		return "course/addLecturePg";
	}
	
	@PostMapping("/course/addLecture")
	public String addLecture(@ModelAttribute("addLecture") UploadLectureDTO addLecture) {

		lectureService.addLecture(addLecture);
		
		return "course/addLectureSuccess";
	}
	
	
	
}





















