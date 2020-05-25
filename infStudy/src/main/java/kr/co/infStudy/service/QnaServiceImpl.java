package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaDAO;
import kr.co.infStudy.dto.qna.QnaDTO;
/**
 * 
 * @author hydes
 * qna 테이블의 CRUD를 위한 메소드
 */
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO dao;
	
	/**
	 * 강의에 대한 질문 전체를 가져오는 메소드
	 */
	@Override
	public ArrayList<QnaDTO> getQnaList(String lecture_title, String search) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("lecture_title", lecture_title);
		hmap.put("search", search);
		
		return (ArrayList<QnaDTO>) dao.getQnaList(hmap);
	}
	/**
	 * 강의 상세내용 조회를 위한 메소드
	 */
	@Override
	public QnaDTO getQnaDetail(int q_no) {
		
		return dao.getQnaDetail(q_no);
	}

}
