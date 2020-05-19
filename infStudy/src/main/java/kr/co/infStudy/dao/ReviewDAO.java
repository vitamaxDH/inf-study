package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.dto.lecture.LectureReviewDTO;

public interface ReviewDAO {

	List<LectureReviewDTO> getLectureReviews(String lecture_title);

}
