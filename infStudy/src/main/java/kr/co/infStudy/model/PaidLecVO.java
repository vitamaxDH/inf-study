package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author hydes
 * DB의 paid_lec 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class PaidLecVO {
	private int p_no;
	private int u_no;
	private int l_no;
	private Date paid_dt;
}
