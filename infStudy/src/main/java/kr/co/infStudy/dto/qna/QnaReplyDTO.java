package kr.co.infStudy.dto.qna;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaReplyDTO {

	private int qr_no;
	private String reply_writer;
	private String reply_writer_img;
	private Date reply_reg_dt;
	private String reply_content;
}
