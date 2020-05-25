package kr.co.infStudy.dto.lecture;

import lombok.Data;

/**
 * 
 * @author hydes
 * 강의 상세페이지(http://localhost:9876/course/{lecture_title})에서 강의 항목들을 가져오는 DTO
 */
@Data
public class LecturesCurriculumDTO {
	
	private int c_no;
	private String section;
	private String curriculum_title;
	private String playtime;
	private String url;

}
