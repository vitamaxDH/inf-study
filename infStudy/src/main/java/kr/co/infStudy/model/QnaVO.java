package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QnaVO {
	private int q_no;
	private int u_no;
	private int l_no;
	private Date reg_dt;
	private String title;
	private String content;


}
