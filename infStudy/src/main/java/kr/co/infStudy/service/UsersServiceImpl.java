package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.PaidLecDAO;
import kr.co.infStudy.dao.UsersDAO;
import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersDAO userDAO;
	private PaidLecDAO paidLecDAO;
	
	@Autowired
	public UsersServiceImpl(UsersDAO userDAO, PaidLecDAO paidLecDAO) {
		this.userDAO = userDAO;
		this.paidLecDAO = paidLecDAO;
	}

	@Override
	public UsersVO selectUser(int u_no) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("u_no", u_no);
		return userDAO.selectUser(map);
	}
	
	@Override
	public List<MyCoursesDTO> getMyCoursesList(UsersVO usersVO) throws Exception {
		List<PaidLecVO> paidLecList = paidLecDAO.getPaidLecList(usersVO.getU_no());
		List<MyCoursesDTO> myCoursesList = new ArrayList<MyCoursesDTO>();
		for(PaidLecVO vo : paidLecList) {
			myCoursesList.add(userDAO.selectMyCoursesDTO(vo));
		}
		
		return myCoursesList;
	}
}
