package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaReplyDAO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {

	@Autowired
	private QnaReplyDAO dao;
}
