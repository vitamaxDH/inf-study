package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;

public interface CurriculumDAO {

	List<LecturesCurriculumDTO> getCurriculumList(String lecture_title);

}
