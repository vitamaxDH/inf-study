package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaReplyDAO;
import kr.co.infStudy.dto.qna.QnaReplyDTO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {

	@Autowired
	private QnaReplyDAO dao;
	
	@Override
	public ArrayList<QnaReplyDTO> getQnaReplyList(int q_no) {
		
		return (ArrayList<QnaReplyDTO>) dao.getQnaReplyList(q_no);
	}
}
