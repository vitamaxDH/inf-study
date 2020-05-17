package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.qna.QnaReplyDTO;

public interface QnaReplyService {

	ArrayList<QnaReplyDTO> getQnaReplyList(int q_no);

}
