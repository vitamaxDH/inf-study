package kr.co.infStudy.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.PaidLecDAO;
import kr.co.infStudy.dao.UsersDAO;
import kr.co.infStudy.dto.user.MyCoursesDTO;
import kr.co.infStudy.model.PaidLecVO;
import kr.co.infStudy.model.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersDAO userDAO;
	private PaidLecDAO paidLecDAO;
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;
	

	@Autowired
	public UsersServiceImpl(UsersDAO userDAO, PaidLecDAO paidLecDAO) {
		this.userDAO = userDAO;
		this.paidLecDAO = paidLecDAO;
	}

	@Override
	public UsersVO selectUser(int u_no) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("u_no", u_no);
		return userDAO.selectUser(map);
	}
	
	@Override
	public List<MyCoursesDTO> getMyCoursesList(UsersVO usersVO) throws Exception {
		List<PaidLecVO> paidLecList = paidLecDAO.getPaidLecList(usersVO.getU_no());
		List<MyCoursesDTO> myCoursesList = new ArrayList<MyCoursesDTO>();
		for(PaidLecVO vo : paidLecList) {
			myCoursesList.add(userDAO.selectMyCoursesDTO(vo));
		}
		
		return myCoursesList;
	}
	
	@Override
	public void registerUser(UsersVO vo) throws Exception {
		
		String pw = vo.getPassword();
		vo.setPassword(DigestUtils.sha256Hex(vo.getPassword()));
//		System.out.println("encPW: " +vo.getPassword());
//		System.out.println("chk: " +vo.getPassword().equals(DigestUtils.sha256Hex(pw)));
		userDAO.registerUser(vo);
	}

	/*
	 * @Override public UsersVO loginUser(UsersVO vo) throws Exception {
	 * HashMap<String, String> map = new HashMap<>(); map.put("email",
	 * vo.getEmail()); map.put("password",vo.getPassword());
	 * 
	 * return userDAO.loginUser(map); }
	 */
	
	/**
	 * 로그인 
	 */
	@Override
	public void loginUser(UsersVO vo) throws Exception {	

		String inputPw = DigestUtils.sha256Hex(vo.getPassword());
		vo.setPassword(inputPw);

		UsersVO tempVO = userDAO.loginUser(vo);
		
		if(tempVO != null) {
			
			login.setLoginInfo(tempVO);
			
			paidLecDAO.getPaidLecList(login.getU_no()).stream()
													  .forEach(o -> login.getClassList()
															  			 .add(o.getL_no()));
		}
		
	}
	
	/**
	 * 지식공유자로 등록하기
	 */
	@Override
	public void enrollInstrunctor(int u_no) {
		userDAO.enrollInstructor(u_no);
	}

	/**
	 * 로그아웃
	 */
	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href=document.referrer;");
		out.println("</script>");
		out.close();
	}
	
	@Override
	public UsersVO getEmailUser(UsersVO vo) throws Exception {

	      return userDAO.getEmailUser(vo);
      
   }

   @Override
   public UsersVO getNickNameUser(UsersVO vo) throws Exception {
      // TODO Auto-generated method stub
      return userDAO.getNickNameUser(vo);
   }
   
   @Override
   public void updateNickname(UsersVO vo) throws Exception {
      userDAO.updateNickname(vo);
   }

   @Override
   public void updatePassword(UsersVO vo) throws Exception {
      // TODO Auto-generated method stub
      String encrypt = DigestUtils.sha256Hex(vo.getNewPw());
      vo.setPassword(encrypt);
      System.out.println(vo);
      userDAO.updatePassword(vo);
   }
   
   /**
    * 회원 탈퇴
    */
   @Override
	public void byeUser(UsersVO vo) throws Exception {
		
	   vo.setPassword(DigestUtils.sha256Hex(vo.getPassword()));
	   
	   userDAO.byeUser(vo);
	}
   
   
}
