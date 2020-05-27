package kr.co.infStudy.model;


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
	
	private String google_url;
	private String naver_url;
	private boolean emailExist;
	
	private boolean userLogin;

	public UsersVO() {	
		this.emailExist = false;
		this.userLogin = false;
	}

}
