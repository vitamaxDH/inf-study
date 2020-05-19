package kr.co.infStudy.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.infStudy.dto.lecture.LectureReplyDTO;

public interface ReviewReplyDAO {

	List<LectureReplyDTO> getReviewReplies(String lecture_title);

}
