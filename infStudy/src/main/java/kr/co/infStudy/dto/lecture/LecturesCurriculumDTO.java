package kr.co.infStudy.dto.lecture;

import java.util.ArrayList;

import lombok.Data;

@Data
public class LecturesCurriculumDTO {
	
	private int c_no;
	private String section;
	private String curriculum_title;
	private String playtime;
	private String url;	
	
	public LecturesCurriculumDTO(LectureDetailDTO dto) {
		this.c_no = dto.getC_no();
		this.section = dto.getSection();
		this.curriculum_title = dto.getCurriculum_title();
		this.playtime = dto.getPlaytime();
		this.url = dto.getUrl();
		
	}

}
