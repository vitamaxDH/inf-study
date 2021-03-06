package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

public interface PaidLecDAO {

	public List<PaidLecVO> getPaidLecList(int u_no) throws Exception;

	public void addPaidLecture(HashMap<String, Integer> hmap);
}
