package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.ReviewDAO;
import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO dao;

	@Override
	public ArrayList<AllReviewDTO> getAllReviewList() {
		return  (ArrayList<AllReviewDTO>) dao.getAllReviewList();
	}

	//게시물 목록 조회
	@Override
	public List<AllReviewDTO> reviewList(ReviewCriteria cri) throws Exception{
		return dao.reviewList(cri);
	}

	//게시물 총 갯수
	@Override
	public int reviewListCount() throws  Exception{
		return dao.reviewListCount();
	}

}
