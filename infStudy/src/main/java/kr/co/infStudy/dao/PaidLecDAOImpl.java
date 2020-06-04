package kr.co.infStudy.dao;

import java.util.HashMap;
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
	/**
	 * 수강 중인 강의 조회
	 */
	@Override
	public List<PaidLecVO> getPaidLecList(int u_no) throws Exception {
		return session.selectList(nameSpace + "getPaidLecList", u_no);
	}
	
	/**
	 * 수강신청
	 */
	@Override
	public void addPaidLecture(HashMap<String, Integer> hmap) {
		session.insert(nameSpace + "addPadiLecture", hmap); 
	}
}
