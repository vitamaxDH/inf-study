package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.LectureDAO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO dao;

	
	@Override
	public ArrayList<LectureDTO> getLectureInfo(String category_name, String sort) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		
		hmap.put("category_name", category_name);
		hmap.put("sort", sort);
		
		return (ArrayList<LectureDTO>)dao.getLectureInfo(hmap);
	}
	
	@Override
	public ArrayList<LectureDetailDTO> getLectureDetail(String lecture_title) {
		
		return (ArrayList<LectureDetailDTO>)dao.getLectureDetail(lecture_title);
	}
	
}





























