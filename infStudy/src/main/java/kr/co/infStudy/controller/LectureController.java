package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.LectureDTO;
import kr.co.infStudy.service.LectureService;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@GetMapping(produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<LectureDTO> lectures_page(Model model) {
		
		ArrayList<LectureDTO> allLectureList = lectureService.getAllLectureInfo();
	
		return allLectureList;
	}
	
	@GetMapping(value = "/{category_name}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<LectureDTO> select_lecture(@PathVariable String category_name,
												@RequestParam(required = false, defaultValue = "price") String sort) {
		
		ArrayList<LectureDTO> specificLectureList = lectureService.getLectureByCategory(category_name, sort);
		
		return specificLectureList;
	}

}


