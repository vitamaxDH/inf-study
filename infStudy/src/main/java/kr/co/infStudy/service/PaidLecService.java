package kr.co.infStudy.service;

import java.util.List;

import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

public interface PaidLecService {
	public List<PaidLecVO> getPaidLecList(int u_no) throws Exception;

}
