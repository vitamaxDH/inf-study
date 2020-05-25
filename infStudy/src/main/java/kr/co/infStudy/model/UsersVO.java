package kr.co.infStudy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 users 테이블에 대응하는 VO
 */
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
