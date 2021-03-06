package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;
import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;
import kr.co.infStudy.model.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.reviewMapper.";
	
	@Override
	public List<LectureReviewDTO> getLectureReviews(String lecture_title) {
		
		return session.selectList(nameSpace + "getLectureReviews", lecture_title);
	}
	
	@Override
	public List<AllReviewDTO> getAllReviewList() {

		return session.selectList(nameSpace + "getAllReviewList");
	}
	
	//게시물 목록 조회
	@Override
	public List<AllReviewDTO> reviewList(ReviewCriteria cri) throws Exception{
		return session.selectList(nameSpace + "reviewListPage", cri);
	}

	//게시물 총 갯수
	@Override
	public int reviewListCount() throws  Exception{
		return session.selectOne(nameSpace + "reviewListCount");
	}
	
	/**
	 * 강의 리뷰 등록
	 */
	@Override
	public void addReview(ReviewVO reviewVO) {
		session.insert(nameSpace + "addReview", reviewVO);
	}
	
}
