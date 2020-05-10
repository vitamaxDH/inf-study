package kr.co.infStudy.dao;

import kr.co.infStudy.model.TestCkVO;

public interface TestCkDAO {
	
	public int testSave(TestCkVO vo);
	
	public TestCkVO getVO(int id);
}
