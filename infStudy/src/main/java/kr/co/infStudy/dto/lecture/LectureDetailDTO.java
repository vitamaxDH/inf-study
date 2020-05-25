package kr.co.infStudy.dto.lecture;

import lombok.Data;


/**
 *  강의 상세 내용을 보여주는 DTO
 */
@Data
public class LectureDetailDTO {
	
	private int l_no;			// lecture idx 
	private String lecture_title;
	private String teacher;		// l_no로 join해서 teacher이름 가져오기
	private String img;			// l_no로 join해서 lecture img 가져오기
	private double rank_avg;	// 강의 평점
	private int review_cnt; 	// 수강평 개수
	private int student_cnt;	// 수강생 수
	private String category;
	
	private int price;
	private int curriculum_cnt;
	private String total_runtime;
	private String difficulty;
	private int wishlist_cnt;

//  아래에는 로그인했을 때 보여줄 것들에 대한 필드값 정의하기
	 
}