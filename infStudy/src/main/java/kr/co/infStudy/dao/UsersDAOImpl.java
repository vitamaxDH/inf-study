package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.usersMapper.";
	
	@Override
	public UsersVO selectUser(HashMap<String, Integer> map) throws Exception {
		System.out.println("daoimpl u_no = " + map);
		return session.selectOne(nameSpace + "getUser", map);
	}
	
	@Override
	public MyCoursesDTO selectMyCoursesDTO(PaidLecVO paidLecVO) throws Exception {
		return session.selectOne(nameSpace + "getMyCourse", paidLecVO);
	}
	
}
