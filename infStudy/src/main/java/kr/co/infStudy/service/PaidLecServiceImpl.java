package kr.co.infStudy.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.PaidLecDAO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Service
public class PaidLecServiceImpl implements PaidLecService {

	@Autowired
	private PaidLecDAO dao;
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;
	
	/**
	 * 강의 등록하기
	 */
	@Override
	public List<PaidLecVO> getPaidLecList(int u_no) throws Exception {
		return dao.getPaidLecList(u_no);
	}
	
	/**
	 * 수강신청
	 */
	@Override
	public void addPaidLecture(int l_no) {
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("l_no", l_no);
		hmap.put("u_no", login.getU_no());
		dao.addPaidLecture(hmap);
		login.getClassList().add(l_no);
	}
}
