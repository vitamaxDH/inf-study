package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.infStudy.dao.ReviewDAO;
import kr.co.infStudy.dao.ReviewReplyDAO;
import kr.co.infStudy.dto.lecture.LectureReplyDTO;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;

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
}
