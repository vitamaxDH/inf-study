package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.model.CurriculumVO;

@Repository
public class CurriculumDAOImpl implements CurriculumDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.curriculumMapper.";
	
	@Override
	public List<LecturesCurriculumDTO> getCurriculumList(String lecture_title) {
		
		return session.selectList(nameSpace + "getCurriculumList", lecture_title);
	}
	
	/**
	 * 강의 등록하기
	 */
	@Override
	public void addCurriculum(CurriculumVO addCurriculumVO) {
		
		session.insert(nameSpace + "addCurriculum", addCurriculumVO);	
	}
	
	/**
	 * 강의 내 커리큘럼 섹션 가져오기 - 강의 등록시
	 */
	@Override
	public List<CurriculumVO> getSectionList(int l_no) {
		
		return session.selectList(nameSpace + "getSectionList", l_no);
	}
}
