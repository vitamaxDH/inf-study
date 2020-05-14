package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

public interface UsersDAO {
	
	public UsersVO selectUser(HashMap<String, Integer> map) throws Exception;
	
	public MyCoursesDTO selectMyCoursesDTO(PaidLecVO paidLecVO) throws Exception;
}
