package kr.co.infStudy.model;

import kr.co.infStudy.dto.lecture.AddCurriculumDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 curriculum 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class CurriculumVO {
	private int c_no;
	private int l_no;
	private String section;
	private String title;
	private String url;
	private int playtime;

}
