package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaSearchCriteria;
import kr.co.infStudy.model.QnaVO;

public interface QnaService {

	ArrayList<QnaDTO> getQnaList(String lecture_title, String search);

	QnaDTO getQnaDetail(int q_no);

	ArrayList<AllQnaDTO> getAllQnaLists();
	
	//게시물 목록 조회
	public List<QnaDTO> qnaList(QnaCriteria cri) throws Exception;

	//게시물 총 갯수
	public int qnaListCount() throws  Exception;
	
	//게시물 총 갯수
	public int qnaListCounts(QnaSearchCriteria scri) throws  Exception;

	void addQna(QnaVO qnaVO);
	

	ArrayList<AllQnaDTO> getMyQnaList(int u_no, String keyword);
}
