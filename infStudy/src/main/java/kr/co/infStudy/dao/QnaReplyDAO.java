package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.model.QnaReplyVO;

public interface QnaReplyDAO {

	List<QnaReplyDTO> getQnaReplyList(int q_no);

	void addQnaReply(QnaReplyVO qnaReply);

	List<QnaReplyVO> getLectureQrList(List<String> qNoList);

}
