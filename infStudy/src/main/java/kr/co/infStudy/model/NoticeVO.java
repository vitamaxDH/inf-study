package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 notice 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class NoticeVO {
	private int n_no;
	private int u_no;
	private String title;
	private String content;
	private Date reg_dt;
}
