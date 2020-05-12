package kr.co.infStudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculumVO {
	private int c_no;
	private int l_no;
	private String section;
	private String title;
	private String content;
	private int playtime;
}
