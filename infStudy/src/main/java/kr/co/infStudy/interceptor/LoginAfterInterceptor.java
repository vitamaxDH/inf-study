package kr.co.infStudy.interceptor;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.infStudy.model.UsersVO;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter{

      private static final Logger logger = LoggerFactory.getLogger(LoginAfterInterceptor.class);

      @Lazy
      @Resource(name = "login")
      private UsersVO login;
      
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
         
//         HttpSession session = request.getSession();
         System.out.println("login값 내놔 :  "+login);
         if(login.getU_no()!=0) {
            response.sendRedirect(request.getContextPath()+"/loginAfter");
            return false;
         }
         
         return true;
      }
      
      
}