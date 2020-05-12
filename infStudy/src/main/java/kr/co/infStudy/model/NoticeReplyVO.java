package kr.co.infStudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeReplyVO {
	private int nr_no;
	private int n_no;
	private int u_no;
	private String content;
}
