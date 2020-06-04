package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.model.QnaReplyVO;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.qnaReplyMapper.";
	
	@Override
	public List<QnaReplyDTO> getQnaReplyList(int q_no) {
		
		return session.selectList(nameSpace + "getQnaReplyList", q_no);
	}
	
	@Override
	public void addQnaReply(QnaReplyVO qnaReply) {
		session.insert(nameSpace + "addQnaReply", qnaReply);
	}
	
	@Override
	public List<QnaReplyVO> getLectureQrList(List<String> qNoList) {
		return session.selectList(nameSpace + "getLectureQrList", qNoList);
	}
}
