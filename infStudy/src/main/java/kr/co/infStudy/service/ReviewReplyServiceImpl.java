package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.ReviewReplyDAO;
import kr.co.infStudy.model.ReviewReplyVO;

@Service
public class ReviewReplyServiceImpl implements ReviewReplyService {

	@Autowired
	private ReviewReplyDAO dao;
	
	@Override
	public void addReviewReply(ReviewReplyVO reviewReplyVO) {
		dao.addReviewReply(reviewReplyVO);
	}
}
