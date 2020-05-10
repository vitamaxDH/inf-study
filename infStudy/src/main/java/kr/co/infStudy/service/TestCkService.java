package kr.co.infStudy.service;

import kr.co.infStudy.model.TestCkVO;

public interface TestCkService {
	
	public int testSave(TestCkVO vo);
	
	public TestCkVO getVO(int id);
}
