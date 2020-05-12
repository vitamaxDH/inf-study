package kr.co.infStudy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.qnaReplyMapper.";
}
