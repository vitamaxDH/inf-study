package kr.co.infStudy.dto.lecture;

import java.util.ArrayList;

import lombok.Data;
/**
 * 
 * @author hydes
 * 강의 평가를 가져오는 DTO
 */
@Data
public class LectureReviewDTO {
	
	private int r_no;
	private int u_no;
	private int rank;
	private String reviewer;
	private String reviewer_img;
	private String review_content;
	private String review_reg_dt;
	
	private ArrayList<LectureReplyDTO> replies;
	
	public LectureReviewDTO() {
		replies = new ArrayList<LectureReplyDTO>();
	}

}
