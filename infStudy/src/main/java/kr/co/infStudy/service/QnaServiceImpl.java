package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaDAO;
import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaSearchCriteria;
import kr.co.infStudy.model.QnaVO;
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
	
	@Override
	public ArrayList<AllQnaDTO> getAllQnaLists() {
		
		return (ArrayList<AllQnaDTO>) dao.getAllQnaLists();
	}
	
	//게시물 목록 조회
	@Override
	public List<QnaDTO> qnaList(QnaCriteria cri) throws Exception{
		return dao.qnaList(cri);
	}

	//게시물 총 갯수
	@Override
	public int qnaListCount() throws  Exception{
		return dao.qnaListCount();
	}
	
	@Override
	public void addQna(QnaVO qnaVO) {
		dao.addQna(qnaVO);
	}
	
	@Override
	public ArrayList<AllQnaDTO> getMyQnaList(int u_no, String keyword) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("keyword", keyword);
		hmap.put("u_no", String.valueOf(u_no));
	
		return (ArrayList<AllQnaDTO>) dao.getMyQnaList(hmap);
	}
	
	//게시물 총 갯수
	@Override
	public int qnaListCounts(QnaSearchCriteria scri) throws  Exception{
		return dao.qnaListCounts(scri);
	}
}
