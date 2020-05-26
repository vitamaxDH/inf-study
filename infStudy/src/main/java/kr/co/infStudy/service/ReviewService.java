package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;

public interface ReviewService {

	ArrayList<AllReviewDTO> getAllReviewList();
	
	//게시물 목록 조회
	public List<AllReviewDTO> reviewList(ReviewCriteria cri) throws Exception;

	//게시물 총 갯수
	public int reviewListCount() throws  Exception;
}
