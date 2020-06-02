package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.infStudy.model.CategoryVO;

public interface CategoryService {

	ArrayList<CategoryVO> getCategoryList();

	void addCategory(String ctg_name);
}
