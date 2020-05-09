package kr.co.infStudy.model;

public class UsersVO {
	private int u_no;
	private String email;
	private String password;
	private String nickname;
	private String img;

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "UsersDAO [u_no=" + u_no + ", email=" + email + ", password=" + password + ", nickname=" + nickname
				+ ", img=" + img + "]";
	}

}
