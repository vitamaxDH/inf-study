package kr.co.infStudy.dao;

import java.util.List;

import kr.co.infStudy.dto.LectureDTO;

public interface LectureDAO {

	List<LectureDTO> getAllLectureInfo();

	List<LectureDTO> getLectureByCategory(String category_name);

}
