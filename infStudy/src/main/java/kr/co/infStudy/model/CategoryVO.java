package kr.co.infStudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB에서 category에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class CategoryVO {
	private int ctg_no;
	private String name;
}
