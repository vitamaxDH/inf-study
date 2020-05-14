package kr.co.infStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.PaidLecDAO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Service
public class PaidLecServiceImpl implements PaidLecService {

	@Autowired
	private PaidLecDAO dao;
	
	@Override
	public List<PaidLecVO> selectPaidLecList(int u_no) throws Exception {
		return dao.selectPaidLecList(u_no);
	}
}
