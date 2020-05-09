package kr.co.infStudy.model;

import java.sql.Date;

public class QnaVO {
	private int q_no;
	private int u_no;
	private int l_no;
	private Date reg_dt;
	private String title;
	private String content;

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "QnaVO [q_no=" + q_no + ", u_no=" + u_no + ", l_no=" + l_no + ", reg_dt=" + reg_dt + ", title=" + title
				+ ", content=" + content + "]";
	}

}
