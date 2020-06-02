package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.model.CategoryVO;

public interface CategoryDAO {

	List<CategoryVO> getCategoryList();

	void addCategory(String ctg_name);

}
