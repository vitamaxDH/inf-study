package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.model.LectureVO;

@Repository
public class LectureDAOImpl implements LectureDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.lectureMapper.";

	
	@Override
	public List<LectureDTO> getLectureInfo(HashMap<String, String> hmap) {
		
		return session.selectList(nameSpace + "getLectureInfo", hmap);
	}
	
	@Override
	public LectureDetailDTO getLectureDetail(String lecture_title) {
		
		return session.selectOne(nameSpace + "getLectureDetail", lecture_title);
	}
	
	@Override
	public void addLecture(LectureVO lectureVO) {
		
		session.insert(nameSpace + "addLecture", lectureVO);
	}
	
}
