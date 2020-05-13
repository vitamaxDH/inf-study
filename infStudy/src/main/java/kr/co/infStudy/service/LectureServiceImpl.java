package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.LectureDAO;
import kr.co.infStudy.dto.LectureDTO;
import kr.co.infStudy.model.LectureVO;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO dao;
	
	@Override
	public ArrayList<LectureDTO> getAllLectureInfo() {
		
		return (ArrayList<LectureDTO>)dao.getAllLectureInfo();
	}
	
	@Override
	public ArrayList<LectureDTO> getLectureByCategory(String category_name, String sort) {
		
		
		
		return (ArrayList<LectureDTO>)dao.getLectureByCategory(category_name);
	}
}
