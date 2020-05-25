package kr.co.infStudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 instructor 테이블에 대응하는 VO
 * 
 */
@Data
@NoArgsConstructor
public class InstructorVO {
	private int l_no;
	private String name;
	private String img;
}
