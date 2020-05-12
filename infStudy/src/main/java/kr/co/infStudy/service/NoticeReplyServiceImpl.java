package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.NoticeReplyDAO;

@Service
public class NoticeReplyServiceImpl implements NoticeReplyService {
	
	@Autowired
	private NoticeReplyDAO dao;
}
