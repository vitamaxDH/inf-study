package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.infStudy.dao.ReviewDAO;
import kr.co.infStudy.dao.ReviewReplyDAO;
import kr.co.infStudy.dto.lecture.LectureReplyDTO;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;
import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;
import kr.co.infStudy.model.ReviewVO;

/**
 * 
 * @author hydes
 * review 테이블의 CRUD를 위한 Service 클래스
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO dao;
	
	@Autowired
	private ReviewReplyDAO rrdao;
	
	
	/**
	 * 강의 review를 보여줄 때 강의 평가(review)와 강사의 답변(review_reply)를 
	 * 계층형으로 보여주기 위해 lectureReview에 reply를 list형태로 넣어서 반환하는 메소드
	 */
	@Transactional
	@Override
	public ArrayList<LectureReviewDTO> getLectureReviews(String lecture_title) {
		
		ArrayList<LectureReviewDTO> lectureReviews = (ArrayList<LectureReviewDTO>) dao.getLectureReviews(lecture_title);
		ArrayList<LectureReplyDTO> replies = (ArrayList<LectureReplyDTO>) rrdao.getReviewReplies(lecture_title);
		
		for(LectureReviewDTO review : lectureReviews) {
			for(LectureReplyDTO reply : replies) {
				if(review.getR_no() == reply.getR_no()) {
					
					review.getReplies().add(reply);									
				}
			}
		}
			
		return lectureReviews;
	}

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
	/**
	 *  강의 리뷰 등록하기
	 */
	@Override
	public void addReview(ReviewVO reviewVO) {
		dao.addReview(reviewVO);
	}
}
