package kr.co.infStudy.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersVO {
	private int u_no;
	private String email;
	private String password;
	private String nickname;
	private String img;

}
