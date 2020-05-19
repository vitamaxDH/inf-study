package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;

@Repository
public class CurriculumDAOImpl implements CurriculumDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.curriculumMapper.";
	
	@Override
	public List<LecturesCurriculumDTO> getCurriculumList(String lecture_title) {
		
		return session.selectList(nameSpace + "getCurriculumList", lecture_title);
	}
}
