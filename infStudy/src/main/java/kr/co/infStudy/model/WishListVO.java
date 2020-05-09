package kr.co.infStudy.model;

import java.sql.Date;

public class WishListVO {
	private int w_no;
	private int u_no;
	private int l_no;
	private Date select_order;

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
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

	public Date getSelect_order() {
		return select_order;
	}

	public void setSelect_order(Date select_order) {
		this.select_order = select_order;
	}

	@Override
	public String toString() {
		return "WishListVO [w_no=" + w_no + ", u_no=" + u_no + ", l_no=" + l_no + ", select_order=" + select_order
				+ "]";
	}

}
