package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.model.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.categoryMapper.";
	
	@Override
	public List<CategoryVO> getCategoryList() {
		return session.selectList(nameSpace + "getCategoryList");
	}
}
