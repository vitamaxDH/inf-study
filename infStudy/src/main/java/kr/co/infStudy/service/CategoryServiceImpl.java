package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CategoryDAO;
import kr.co.infStudy.model.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO dao;
	
	@Override
	public ArrayList<CategoryVO> getCategoryList() {
		
		return (ArrayList<CategoryVO>) dao.getCategoryList();
	}
}
