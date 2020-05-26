package kr.co.infStudy.dto.review;

import java.util.Date;

import lombok.Data;

@Data
public class AllReviewDTO {
	
	private String review_writer;
	private Date review_dt;
	private String lec_title;
	private int review_rank;
	private String review_content;
}