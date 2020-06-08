package kr.co.infStudy.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.infStudy.model.UsersVO;
/**
 * 
 * @author sammy
 * 권한이 필요한 창에 로그인이 되지 않으면 접근을 막는 인터셉터
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {	

		HttpSession session = request.getSession();
		
		String url =  (String) session.getAttribute("url");
		System.out.println("인터셉터에서 loginVO : "+login);
		System.out.println("url 내놔!! : " +url);
		

		if(login==null || login.getU_no()==0) {

			
			response.sendRedirect("interLogin");
			return false;			
		}
		
		return true;
	}

	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}



	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	

}
