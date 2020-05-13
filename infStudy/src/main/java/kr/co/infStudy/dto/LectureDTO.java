package kr.co.infStudy.dto;

import lombok.Data;

@Data
public class LectureDTO {
	
	private String title;
	private String content;
	private int price;
	private String img;
	private int rank;
	private String teacher;
	private String category;

}
