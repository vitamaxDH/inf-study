package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CurriculumDAO;
import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
/**
 * 
 * @author hydes
 * 강의 상세 보기에서 해당 강좌의 강의 리스트를 가져오기 위한 Service 클래스
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

	@Autowired
	private CurriculumDAO dao;
	
	@Override
	public ArrayList<LecturesCurriculumDTO> getCurriculumList(String lecture_title) {
		
		return (ArrayList<LecturesCurriculumDTO>) dao.getCurriculumList(lecture_title);
	}
}
