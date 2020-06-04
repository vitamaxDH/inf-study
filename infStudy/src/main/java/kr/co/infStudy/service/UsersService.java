package kr.co.infStudy.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.UsersVO;

public interface UsersService {
	
	public UsersVO selectUser(int u_no) throws Exception;
	
	public List<MyCoursesDTO> getMyCoursesList(UsersVO usersVO) throws Exception;

	public void registerUser(UsersVO vo) throws Exception;

	public void loginUser(UsersVO vo) throws Exception;

	public void logout(HttpServletResponse response) throws Exception;

	public void enrollInstrunctor(int u_no);

	public UsersVO getEmailUser(UsersVO vo) throws Exception;

	public UsersVO getNickNameUser(UsersVO vo) throws Exception;

	public void byeUser(UsersVO byeUserVO) throws Exception;

	public void updateNickname(UsersVO vo) throws Exception;

	void updatePassword(UsersVO vo) throws Exception;
	
}
