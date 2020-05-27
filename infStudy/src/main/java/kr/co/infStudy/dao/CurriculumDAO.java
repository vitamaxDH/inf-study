package kr.co.infStudy.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.model.CurriculumVO;

public interface CurriculumDAO {

	List<LecturesCurriculumDTO> getCurriculumList(String lecture_title);

	void addCurriculum(CurriculumVO addCurriculumVO);

	List<CurriculumVO> getSectionList(int l_no);

}
