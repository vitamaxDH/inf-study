package kr.co.infStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LectureReplyDTO;
import kr.co.infStudy.model.ReviewReplyVO;

@Repository
public class ReviewReplyDAOImpl implements ReviewReplyDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.reviewReplyMapper.";
	
	
	@Override
	public List<LectureReplyDTO> getReviewReplies(String lecture_title) {
		return session.selectList(nameSpace + "getReviewReplies", lecture_title);
	}
	
	@Override
	public void addReviewReply(ReviewReplyVO reviewReplyVO) {
		session.insert(nameSpace + "addReviewReply", reviewReplyVO);
	}
}
