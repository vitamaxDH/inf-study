package kr.co.infStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CategoryDAO;
import kr.co.infStudy.model.CategoryVO;
/**
 * 
 * @author hydes
 * 카테고리 항목을 가져오기 위한 Service 클래스로 
 * Interceptor로 상단 nav bar에서 강의 항목을 보여주기 위해 사용
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO dao;
	
	@Override
	public ArrayList<CategoryVO> getCategoryList() {
		
		return (ArrayList<CategoryVO>) dao.getCategoryList();
	}
}
