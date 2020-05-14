package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Repository
public class PaidLecDAOImpl implements PaidLecDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.paidLecMapper.";
	
	@Override
	public List<PaidLecVO> selectPaidLecList(int u_no) throws Exception {
		return session.selectList(nameSpace + "selectPaidLec", u_no);
	}
}
