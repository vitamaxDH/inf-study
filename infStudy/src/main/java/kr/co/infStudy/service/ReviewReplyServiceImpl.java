package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.ReviewReplyDAO;

@Service
public class ReviewReplyServiceImpl implements ReviewReplyService {

	@Autowired
	private ReviewReplyDAO dao;
}
