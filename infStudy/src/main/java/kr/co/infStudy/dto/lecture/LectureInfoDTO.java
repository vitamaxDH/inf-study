package kr.co.infStudy.dto.lecture;

import lombok.Data;

@Data
public class LectureInfoDTO {

	//이거는 랭크와 DB 조회하는 쿼리를 새로 짜야할듯.
	private String lecture_title;
	private double rank;
	private int student_cnt;
	private String category;
	private String total_time;
	

}
