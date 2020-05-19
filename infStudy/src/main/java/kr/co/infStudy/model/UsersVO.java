package kr.co.infStudy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersVO {
	private int u_no;
	private String email;
	private String password;
	private String nickname;
	private String img;

}
