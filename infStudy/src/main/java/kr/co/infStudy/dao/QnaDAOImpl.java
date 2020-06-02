package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaSearchCriteria;
import kr.co.infStudy.model.QnaVO;

@Repository
public class QnaDAOImpl implements QnaDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.qnaMapper.";
	
	@Override
	public List<QnaDTO> getQnaList(HashMap<String, String> hmap) {
		return session.selectList(nameSpace + "getQnaList", hmap);
	}
	
	@Override
	public QnaDTO getQnaDetail(int q_no) {
		
		return session.selectOne(nameSpace + "getQnaDetail", q_no);
	}
	
	@Override
	public List<AllQnaDTO> getMyQnaList(HashMap<String, String> hmap) {
		
		return session.selectList(nameSpace + "getMyQnaList", hmap);
	}
	
	//게시물 목록 조회
	@Override
	public List<QnaDTO> qnaList(QnaCriteria cri) throws Exception{
		return session.selectList(nameSpace + "qnaListPage", cri);
	}

	//게시물 총 갯수
	@Override
	public int qnaListCount() throws  Exception{
		return session.selectOne(nameSpace + "qnaListCount");
	}
	
	//Qna 등록
	@Override
	public void addQna(QnaVO qnaVO) {
		session.insert(nameSpace + "addQna", qnaVO);
	}
	
	@Override
	public List<AllQnaDTO> getAllQnaLists() {
		
		return session.selectList(nameSpace + "getAllQnaLists");
	}
	

	//게시물 총 갯수
	@Override
	public int qnaListCounts(QnaSearchCriteria scri) throws  Exception{
		return session.selectOne(nameSpace + "qnaListCounts", scri);
	}
}
