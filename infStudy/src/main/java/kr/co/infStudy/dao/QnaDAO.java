package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.qna.QnaDTO;

public interface QnaDAO {

	List<QnaDTO> getQnaList(HashMap<String, String> hmap);

	QnaDTO getQnaDetail(int q_no);

}
