package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 finish 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class FinishVO {
	private int u_no;
	private int c_no;
	private int finish;
	private Date finishTime;
}
