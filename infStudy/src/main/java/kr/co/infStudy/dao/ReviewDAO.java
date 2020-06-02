package kr.co.infStudy.dao;

import java.util.List;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;
import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;
import kr.co.infStudy.model.ReviewVO;

public interface ReviewDAO {

	List<AllReviewDTO> getAllReviewList();

	List<LectureReviewDTO> getLectureReviews(String lecture_title);
	
	//게시물 목록 조회
	public List<AllReviewDTO> reviewList(ReviewCriteria cri) throws Exception;

	//게시물 총 갯수
	public int reviewListCount() throws  Exception;

	void addReview(ReviewVO reviewVO);
}
