package kr.co.infStudy.dto.lecture;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadLectureDTO {

	private int i_no;
	private int ctg_no;
	private String title;
	private int price;
	private int rank;
	private String difficulty;
	private MultipartFile lectureImg;
	private String img;
	private Date rel_dt;
}
