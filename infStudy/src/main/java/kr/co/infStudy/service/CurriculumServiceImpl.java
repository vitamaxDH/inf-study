package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CurriculumDAO;
import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;

@Service
public class CurriculumServiceImpl implements CurriculumService {

	@Autowired
	private CurriculumDAO dao;
	
	@Override
	public ArrayList<LecturesCurriculumDTO> getCurriculumList(String lecture_title) {
		
		return (ArrayList<LecturesCurriculumDTO>) dao.getCurriculumList(lecture_title);
	}
}
