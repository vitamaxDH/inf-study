package kr.co.infStudy.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@GetMapping(value = "/courses", produces = "application/json; charset=utf-8")
	public String getLectureInfo(@RequestParam(required = false) String category_name,
												@RequestParam(required = false, defaultValue = "price") String order,
												Model model) {
		
		ArrayList<LectureDTO> lectureList = lectureService.getLectureInfo(category_name, order);
		
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("category_name", category_name);
		
		return "course/courseList";
	}
	
	@GetMapping(value = "/course/{lecture_title}", produces = "application/json; charset=utf-8")
	public String getLectureDetail(@PathVariable String lecture_title, Model model) throws Exception{
		
		
		ArrayList<LectureDetailDTO> lectureDetail = lectureService.getLectureDetail(lecture_title);
		
		//자바 - 람다식 & 스트림 - 인강에서 필기한거 베낌. ㅎㅎㅎ나도 잘 모름ㅎㅎㅎ. 다들 자바 열공!!!
		model.addAttribute("curriculum_list", lectureDetail.stream()
															.map(LecturesCurriculumDTO::new)
															.collect(Collectors.toList()));
		
		return "course/courseDetail";
	}
	
	
}





















