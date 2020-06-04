package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.model.QnaReplyVO;

public interface QnaReplyService {

	ArrayList<QnaReplyDTO> getQnaReplyList(int q_no);

	void addQnaReply(QnaReplyVO qnaReply);

}
