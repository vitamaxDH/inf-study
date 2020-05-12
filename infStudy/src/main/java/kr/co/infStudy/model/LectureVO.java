package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureVO {
	private int l_no;
	private int i_no;
	private int ctg_no;
	private String title;
	private int price;
	private int rank;
	private String difficulty;
	private String img;
	private Date rel_dt;
}
