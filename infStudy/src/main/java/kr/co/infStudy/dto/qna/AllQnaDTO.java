package kr.co.infStudy.dto.qna;

import java.util.Date;

import lombok.Data;

@Data
public class AllQnaDTO {

	private int q_no;
	private String qna_title;
	private String qna_writer;
	private Date qna_reg_dt;
	private String lec_title;
	private int qr_count;
}