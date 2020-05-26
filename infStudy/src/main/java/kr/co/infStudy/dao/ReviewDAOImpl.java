package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.reviewMapper.";
	
	
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
	
}
