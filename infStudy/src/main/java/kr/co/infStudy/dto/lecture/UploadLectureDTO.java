package kr.co.infStudy.dto.lecture;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author hydes
 * 강의 업로드 시 입력해야 할 항목에 대한 DTO
 */
@Data
public class UploadLectureDTO {
	private int i_no;
	private int ctg_no;
	private String ctg_name;
	private String title;
	private int price;
	private int rank;
	private String difficulty;
	private MultipartFile lectureImg;
	private String img;
	private Date rel_dt;
	private String content;
}
