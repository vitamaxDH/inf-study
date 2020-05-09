package kr.co.infStudy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.model.TestCkVO;

@Repository
public class TestCkDAOImpl implements TestCkDAO {

	@Autowired
	private SqlSession session;
	
	private String nameSpace = "kr.co.infStudy.testMapper."; 
	
	@Override
	public int testSave(TestCkVO vo) {
		return session.insert(nameSpace + "save", vo); 
	}

}
