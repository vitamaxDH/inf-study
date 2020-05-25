package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 qna_reply 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class QnaReplyVO {
	private int qr_no;
	private int q_no;
	private int u_no;
	private Date reg_dt;
	private String content;


}
