package kr.co.infStudy.service;

import java.util.List;

import kr.co.infStudy.dto.lecture.LectureReviewDTO;

public interface ReviewService {

	List<LectureReviewDTO> getLectureReviews(String lecture_title);

}
