package kr.co.infStudy.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.infStudy.model.CategoryVO;
import kr.co.infStudy.service.CategoryService;

/**
 * @author hydes
 *	상단 메뉴의 강의 항목 리스트를 뽑아오는 클래스
 *
 */
public class CoursesAsideInterceptor implements HandlerInterceptor{

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		ArrayList<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);

		return true;
	}
}
