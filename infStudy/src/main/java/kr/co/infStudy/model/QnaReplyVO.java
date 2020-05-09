package kr.co.infStudy.model;

import java.sql.Date;

public class QnaReplyVO {
	private int qr_no;
	private int q_no;
	private int u_no;
	private Date reg_dt;
	private String content;

	public int getQr_no() {
		return qr_no;
	}

	public void setQr_no(int qr_no) {
		this.qr_no = qr_no;
	}

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
		return "QnaReplyVO [qr_no=" + qr_no + ", q_no=" + q_no + ", u_no=" + u_no + ", reg_dt=" + reg_dt + ", content="
				+ content + "]";
	}

}
