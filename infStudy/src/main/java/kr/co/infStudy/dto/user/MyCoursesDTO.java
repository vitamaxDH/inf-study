package kr.co.infStudy.dto.user;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyCoursesDTO {
	
	private String title;
	private String img;
	private String url;
	private double progress;
	private int finish;
	private Date finishTime;
	
}
