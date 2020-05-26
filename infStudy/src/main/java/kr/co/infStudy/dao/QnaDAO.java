package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;

public interface QnaDAO {

	List<QnaDTO> getQnaList(HashMap<String, String> hmap);

	QnaDTO getQnaDetail(int q_no);

	List<AllQnaDTO> getAllQnaList();
	
	//게시물 목록 조회
	public List<QnaDTO> qnaList(QnaCriteria cri) throws Exception;

	//게시물 총 갯수
	public int qnaListCount() throws  Exception;
}
