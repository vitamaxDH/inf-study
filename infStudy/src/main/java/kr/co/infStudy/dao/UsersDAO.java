package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

public interface UsersDAO {

	public UsersVO selectUser(HashMap<String, Integer> map) throws Exception;

	public MyCoursesDTO selectMyCoursesDTO(PaidLecVO paidLecVO) throws Exception;

	public void registerUser(UsersVO vo) throws Exception;

	public UsersVO loginUser(UsersVO vo) throws Exception;

	public void enrollInstructor(int u_no);

	public UsersVO getEmailUser(UsersVO vo) throws Exception;

	public UsersVO getNickNameUser(UsersVO vo) throws Exception;

	public void byeUser(UsersVO vo) throws Exception;

	public void updatePassword(UsersVO vo) throws Exception;

	public void updateNickname(UsersVO vo) throws Exception;
}
