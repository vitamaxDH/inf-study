package kr.co.infStudy.dto.lecture;

import lombok.Data;
/**
 * 
 * @author hydes
 * 강의 리스트(http://localhost:9876/courses)에서 강의 항목을 뿌려주는 내용
 * 
 */
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
