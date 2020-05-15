package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
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
		
		return "course/courseList";
	}
	
	@GetMapping(value = "/course/{lecture_title}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<LectureDetailDTO> getLectureDetail(@PathVariable String lecture_title) throws Exception{
		
		
		ArrayList<LectureDetailDTO> result = lectureService.getLectureDetail(lecture_title);
		
		/**
		 * 뷰 단에서 뿌려주는 방식은 아래와 같이
		 */
		/*ㅇㅇ
		for(int i = 1; i < result.size(); i++) {
			
			if(i == 1) {
				System.out.println(result.get(0).getSection());
				System.out.println(result.get(0));
			}
			
			if(!result.get(i-1).getSection().equals(result.get(i).getSection())) {
				System.out.println(result.get(i).getSection());
			}
			System.out.println(result.get(i+2));
		}
		*/	
		return result;
	}
	
}





















