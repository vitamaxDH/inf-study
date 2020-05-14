package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.qna.QnaDTO;

public interface QnaService {

	ArrayList<QnaDTO> getQnaList(String lecture_title, String search);

	QnaDTO getQnaDetail(String q_no);


}
