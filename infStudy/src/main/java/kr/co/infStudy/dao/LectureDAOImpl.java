package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.LectureDTO;

@Repository
public class LectureDAOImpl implements LectureDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.lectureMapper.";
	
	@Override
	public List<LectureDTO> getAllLectureInfo() {
		
		return session.selectList(nameSpace + "getAllLectureInfo");
	}
	
	@Override
	public List<LectureDTO> getLectureByCategory(String category_name) {
		
		return session.selectList(nameSpace + "getLectureByCategory", category_name);
	}
	
	
}
