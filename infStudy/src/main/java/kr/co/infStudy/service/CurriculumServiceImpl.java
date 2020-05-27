package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CurriculumDAO;
import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.model.CurriculumVO;
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
	
	/**
	 * 강의 내 커리큘럼 등록하기
	 */
	@Override
	public void addCurriculum(CurriculumVO addCurriculumVO) {
		dao.addCurriculum(addCurriculumVO);
	}
	
	/**
	 * 강의 내 커리큘럼 섹션가져오기 - 강의 등록시 사용
	 */
	@Override
	public ArrayList<String> getSectionList(int l_no) {
	
		return (ArrayList<String>) dao.getSectionList(l_no).stream()
														.map(o->o.getSection())
														.distinct()
														.collect(Collectors.toList());
	}
}
