package kr.co.infStudy.dto.qna;

import lombok.Data;

@Data
public class QnaSearchCriteria extends QnaCriteria {
	
	private String keyword = "";
	
}
