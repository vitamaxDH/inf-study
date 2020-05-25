package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaReplyDAO;
import kr.co.infStudy.dto.qna.QnaReplyDTO;
/**
 * 
 * @author hydes
 * qna_reply 테이블의 CRUD와 관련된 Service 클래스
 */
@Service
public class QnaReplyServiceImpl implements QnaReplyService {

	@Autowired
	private QnaReplyDAO dao;
	
	/**
	 * 강의 질문에 대한 답변을 가져오는 메소드 
	 */
	@Override
	public ArrayList<QnaReplyDTO> getQnaReplyList(int q_no) {
		
		return (ArrayList<QnaReplyDTO>) dao.getQnaReplyList(q_no);
	}
}
