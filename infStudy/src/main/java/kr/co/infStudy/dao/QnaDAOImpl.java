package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.qna.QnaDTO;

@Repository
public class QnaDAOImpl implements QnaDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.qnaMapper.";
	
	@Override
	public QnaDTO getQnaDetail(String q_no) {
		return session.selectOne("tempName");
	}

	@Override
	public List<QnaDTO> getQnaList(HashMap<String, String> hmap) {
		// TODO Auto-generated method stub
		return null;
	}
}
