package kr.co.infStudy.model;

import java.sql.Date;

public class ReviewReplyVO {
	private int rr_no;
	private int r_no;
	private int u_no;
	private Date reg_dt;
	private String content;

	public int getRr_no() {
		return rr_no;
	}

	public void setRr_no(int rr_no) {
		this.rr_no = rr_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReviewReplyVO [rr_no=" + rr_no + ", r_no=" + r_no + ", u_no=" + u_no + ", reg_dt=" + reg_dt
				+ ", content=" + content + "]";
	}

}
