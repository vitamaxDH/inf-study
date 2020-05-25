package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 review_reply 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class ReviewReplyVO {
	private int rr_no;
	private int r_no;
	private int u_no;
	private Date reg_dt;
	private String content;


}
