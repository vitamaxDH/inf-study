package kr.co.infStudy.dto.lecture;

import lombok.Data;

@Data
public class LectureReplyDTO {

	private int rr_no;
	private int r_no;
	private String replier;
	private String replier_img;
	private String reply_content;
	private String reply_reg_dt;
	
}


