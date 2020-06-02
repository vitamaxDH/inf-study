package kr.co.infStudy.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;

import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.oauth.NaverLoginBO;
import kr.co.infStudy.service.UsersService;

/** 
 * @author sammy
 * 회원의 회원가입과 로그인을 담당하는 Controller
 */
@Controller
public class LoginController {
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;

	private UsersService usersService;
	
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
	@Autowired
	public LoginController(UsersService usersService) {
		this.usersService = usersService;
	}

	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	/**
	 * @param regUserVO : 회원 가입에 필요한 정보를  받는 VO
	 * @return : 회원 정보를 입력하는 창으로 리턴
	 * 회원가입 창으로 리턴하는 
	 */
	@GetMapping("/signupForm")
	public String signupForm(@ModelAttribute("regUserVO") UsersVO regUserVO) throws Exception {
//		System.out.println(loginUser);

		return "signup";
	}

	/**
	 * 
	 * @param request
	 * @param regUserVO : 회원 가입에 필요한 정보를 받는 VO
	 * @param result : 에러가 존재하는지 확인하는 메소드
	 * @return : 입력한 정보에 에러가 생기거나 할 경우에 다시 회원가입 창(signup)으로 리턴, 정보에 에러가 존재하지 않을 시 회원가입완료(signupCheck)으로 리턴
	 * @throws Exception
	 * 
	 */
	@PostMapping("/signupCheck")
	public String signupCheck(HttpServletRequest request, @ModelAttribute("regUserVO") @Valid UsersVO regUserVO,
			BindingResult result) throws Exception {

//		System.out.println(reguserVO);
		if (result.hasErrors()) {
			return "signup";
		}
		usersService.registerUser(regUserVO);

		return "signupCheck";
	}
	
	@RequestMapping(value="emailChk")
	   @ResponseBody
	   public int getEamilUser(UsersVO vo) throws Exception {
	      
	      int result=0;
	      UsersVO user = usersService.getEmailUser(vo);
	      if(user !=null) {
	         result =1;
	      }
	      
	      return result;
	   }
	   
	   @RequestMapping(value="nickChk")
	   @ResponseBody
	   public int nickChk(UsersVO vo) throws Exception {
	      int result=0;
	      UsersVO user = usersService.getNickNameUser(vo);
	      if(user!=null) {
	         result=1;
	      }
	      
	      return result;
	   }
	
	/**
	 * 
	 * @param loginUserVO : 이메일과 비밀번호를 받는 VO
	 * @param fail : 로그인할 때 정보가 입력이 되었는지 확인하는 변수
	 * @param model : model에 url 속성을 입력하기 위한 메소드
	 * @param session 
	 * @return : 로그인 창으로 리턴
	 * @throws IOException
	 */
	@RequestMapping(value="loginForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute("loginUserVO") UsersVO loginUserVO,
			@RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model, HttpSession session) throws IOException{
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);		
//		System.out.println("네이버:" + naverAuthUrl);

		OAuth2Operations oauth2Operation= googleConnectionFactory.getOAuthOperations();
		String url = oauth2Operation.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		model.addAttribute("google_url", url);
		System.out.println("google_url : " +url);	
		// 네이버
		model.addAttribute("url", naverAuthUrl);

		System.out.println("model" + model);
		
		model.addAttribute("fail", fail);
	
		return "login/login";
	}

	/**
	 * 
	 * @param request
	 * @return interLogin 창으로 리턴
	 */
	@GetMapping("interLogin")
	public String interLogin(HttpServletRequest request) {

		return "login/interLogin";
	}

	/**
	 * 
	 * @param model
	 * @param code
	 * @param state
	 * @param session
	 * @return
	 * @throws IOException
	 */
	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value="/callback", method= {RequestMethod.GET,RequestMethod.POST})
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		/* 네이버 로그인 성공 페이지 View 호출 */
		return "login/naverSuccess";
	}


	/**
	 * 
	 * @param model
	 * @param code
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/oauth2callback", method= {RequestMethod.GET, RequestMethod.POST})
	public String googleCallback(Model model,@RequestParam String code) throws IOException{
		
		
		System.out.println("googleLoginSuccess");
		
		
		return "login/googleSuccess";
	}
	
	/**
	 * 
	 * @param session
	 * @param loginUserVO
	 * @param result
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("loginCheck")
	public String loginCheck(HttpSession session, @ModelAttribute("loginUserVO") @Valid UsersVO loginUserVO,
			BindingResult result, Model model) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("pwErrorMsg", "비밀번호 입력 필수");
			return "login/login";
		}
		login.setLoginInfo(usersService.loginUser(loginUserVO));

		if (login == null) {

			return "login/loginfail";

		} else {
			
			return "login/loginSuccess";
		}
//		System.out.println("Vo"+loginUserVO);
//		System.out.println("result"+result);

	}


	/**
	 * 
	 * @param session
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("logout")
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		session.invalidate();
		usersService.logout(response);
		response.sendRedirect("login/logoutCheck");

	}

}
