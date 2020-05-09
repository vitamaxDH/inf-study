package kr.co.infStudy.model;

public class PaidLecVO {
	private int p_no;
	private int u_no;
	private int l_no;

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
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

	@Override
	public String toString() {
		return "PaidLecVO [p_no=" + p_no + ", u_no=" + u_no + ", l_no=" + l_no + "]";
	}

}
