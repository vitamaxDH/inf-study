package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;

public interface LectureDAO {

	List<LectureDTO> getLectureInfo(HashMap<String, String> hmap);

	List<LectureDetailDTO> getLectureDetail(String lecture_title);

}
