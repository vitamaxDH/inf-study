package kr.co.infStudy.dto.lecture;

import lombok.Data;

@Data
public class LectureDetailDTO {
	
//	private int c_no;			// 커리큘럼 idx (강의 정렬하기)
//	private int l_no;			// lecture idx 
	private String teacher;		// l_no로 join해서 teacher이름 가져오기
	private String category;
	private String lecture_title;
	private String section;
	private String curriculum_title;
	private String url;
	private String playtime;
	private String img;			// l_no로 join해서 lecture img 가져오기
	
	/**
	 * 	아래에는 로그인했을 때 보여줄 것들에 대한 필드값 정의하기
	 */
	
	
	
	
}
