package kr.co.infStudy.service;

import java.util.List;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.UsersVO;

public interface UsersService {
	
	public UsersVO selectUser(int u_no) throws Exception;
	
	public List<MyCoursesDTO> getMyCoursesList(UsersVO usersVO) throws Exception;
	
}
