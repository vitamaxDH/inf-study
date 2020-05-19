package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.infStudy.dao.ReviewDAO;
import kr.co.infStudy.dao.ReviewReplyDAO;
import kr.co.infStudy.dto.lecture.LectureReplyDTO;
import kr.co.infStudy.dto.lecture.LectureReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO dao;
	
	@Autowired
	private ReviewReplyDAO rrdao;
	
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
