package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.dto.qna.QnaReplyDTO;

public interface QnaReplyDAO {

	List<QnaReplyDTO> getQnaReplyList(String q_no);

}
