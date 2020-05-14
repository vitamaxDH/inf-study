package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

public interface PaidLecDAO {

	public List<PaidLecVO> selectPaidLecList(int u_no) throws Exception;
}
