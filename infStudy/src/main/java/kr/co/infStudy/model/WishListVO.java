package kr.co.infStudy.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * DB의 wishlist 테이블에 대응하는 VO
 */
@Data
@NoArgsConstructor
public class WishListVO {
	private int w_no;
	private int u_no;
	private int l_no;
	private Date select_order;

}
