package kr.co.infStudy.model;


import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 users 테이블에 대응하는 VO
 */
@Data
@AllArgsConstructor
public class UsersVO {
	private int u_no;
	@NotEmpty(message="이메일 입력 필수")
	private String email;
//	@NotEmpty(message="비밀번호 입력 필수")
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String password;
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String passwordChk;
	private String nickname;
	private String img;
	
	private int i_no;
	private String auth;	//LectureDetail에서 일반 사용자인지, 수강생인지, 지식공유자인지를 확인하기 위한 변수
	private ArrayList<Integer> classList;	//수강중인 강의들
	
	
	private String google_url;
	private String naver_url;
	private boolean emailExist;
	
	private boolean userLogin;

	public UsersVO() {	
		this.emailExist = false;
		this.userLogin = false;
		this.classList = new ArrayList<Integer>();
	}
	
	public void setLoginInfo(UsersVO vo) {
		this.u_no = vo.getU_no();
		this.email = vo.getEmail();
		this.password = vo.getPassword();
		this.img = vo.getImg();
		this.nickname = vo.getNickname();
		this.i_no = vo.getI_no();
	}

}
