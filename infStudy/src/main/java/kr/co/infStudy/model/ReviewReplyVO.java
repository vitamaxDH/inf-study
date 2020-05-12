package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewReplyVO {
	private int rr_no;
	private int r_no;
	private int u_no;
	private Date reg_dt;
	private String content;


}
