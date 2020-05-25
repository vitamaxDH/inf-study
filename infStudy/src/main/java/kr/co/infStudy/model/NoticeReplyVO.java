package kr.co.infStudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 notice_reply 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class NoticeReplyVO {
	private int nr_no;
	private int n_no;
	private int u_no;
	private String content;
}
