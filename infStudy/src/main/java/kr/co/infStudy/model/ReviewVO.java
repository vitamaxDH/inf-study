package kr.co.infStudy.model;

import java.sql.Date;

public class ReviewVO {
	private int r_no;
	private int l_no;
	private int u_no;
	private Date reg_dt;
	private int rank;
	private String content;

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReviewVO [r_no=" + r_no + ", l_no=" + l_no + ", u_no=" + u_no + ", reg_dt=" + reg_dt + ", rank=" + rank
				+ ", content=" + content + "]";
	}

}
