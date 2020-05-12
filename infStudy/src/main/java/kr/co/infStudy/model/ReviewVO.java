package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewVO {
	private int r_no;
	private int l_no;
	private int u_no;
	private Date reg_dt;
	private int rank;
	private String content;


}
