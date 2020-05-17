package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.qna.QnaReplyDTO;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.qnaReplyMapper.";
	
	@Override
	public List<QnaReplyDTO> getQnaReplyList(String q_no) {
		
		return session.selectList(nameSpace + "getQnaReplyList", q_no);
	}
}
