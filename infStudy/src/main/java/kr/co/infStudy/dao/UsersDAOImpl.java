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
	
	@Override
	public void registerUser(UsersVO vo) throws Exception {
		session.insert(nameSpace + "registerUser",vo);
	}
 
	/**
	 * 회원이 로그인할때 데이터베이스에서 출력하는 메소드
	 */
	@Override 
	public UsersVO loginUser(UsersVO vo) throws Exception{
//		System.out.println("dao의 vo"+vo);
		 return session.selectOne(nameSpace+"loginUser",vo);
	}
	/**
	 * 지식공유자 등록하기
	 */
	@Override
	public void enrollInstructor(int u_no) {
		session.insert(nameSpace + "enrollInstructor", u_no);
	}
	
	@Override
	public UsersVO getEmailUser(UsersVO vo) throws Exception {
		
	return session.selectOne(nameSpace+"getEmailUser", vo);
	}
	
	@Override
	public UsersVO getNickNameUser(UsersVO vo) throws Exception {
		return session.selectOne(nameSpace+"getNickNameUser", vo);
	}
	
	@Override
	   public void updateNickname(UsersVO vo) throws Exception {
	      
	      session.update(nameSpace+"updateNickname", vo);
	   }

	   @Override
	   public void updatePassword(UsersVO vo) throws Exception {
	      session.update(nameSpace+"updatePassword", vo);
	   }
	
	@Override
	public void byeUser(UsersVO vo) throws Exception {
		session.delete(nameSpace + "byeUser", vo);
	}
	
}
