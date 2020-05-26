package kr.co.infStudy.dto.qna;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaDTO {
	
	private int q_no;
	private String qna_title;
	private String qna_writer;
	private String qna_writer_img;	
	private Date qna_reg_date;
	private String qna_content;
	private int qr_count;
		
}
