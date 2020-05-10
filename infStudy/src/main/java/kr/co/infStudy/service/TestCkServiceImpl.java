package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.TestCkDAO;
import kr.co.infStudy.model.TestCkVO;

@Service
public class TestCkServiceImpl implements TestCkService {

	@Autowired
	private TestCkDAO testCkDAO;
	
	@Override
	public int testSave(TestCkVO vo) {
		return testCkDAO.testSave(vo);
	}
	
	@Override
	public TestCkVO getVO(int id) {
		return testCkDAO.getVO(id);
	}
}
