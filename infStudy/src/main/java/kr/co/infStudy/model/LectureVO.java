package kr.co.infStudy.model;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureVO {
	
	private int l_no;
	private int i_no;
	private int ctg_no;
	private String title;
	private int price;
	private int rank;
	private String difficulty;
	private String img;
	private Date rel_dt;

	public LectureVO(UploadLectureDTO addLecture) {
		
		this.i_no = addLecture.getI_no();
		this.ctg_no = addLecture.getCtg_no();
		this.title = addLecture.getTitle();
		this.price = addLecture.getPrice();
		this.rank = addLecture.getPrice();
		this.difficulty = addLecture.getDifficulty();
		this.img = addLecture.getImg();
	}
}
