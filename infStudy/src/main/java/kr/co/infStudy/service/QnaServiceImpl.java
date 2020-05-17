package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaDAO;
import kr.co.infStudy.dto.qna.QnaDTO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO dao;
	
	@Override
	public ArrayList<QnaDTO> getQnaList(String lecture_title, String search) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("lecture_title", lecture_title);
		hmap.put("search", search);
		
		return (ArrayList<QnaDTO>) dao.getQnaList(hmap);
	}
	
	@Override
	public QnaDTO getQnaDetail(int q_no) {
		
		return dao.getQnaDetail(q_no);
	}

}
