package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LectureReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.reviewMapper.";
	
	@Override
	public List<LectureReviewDTO> getLectureReviews(String lecture_title) {
		
		return session.selectList(nameSpace + "getLectureReviews", lecture_title);
	}
}
