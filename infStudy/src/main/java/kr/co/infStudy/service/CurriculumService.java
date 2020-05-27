package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;
import kr.co.infStudy.model.CurriculumVO;

public interface CurriculumService {

	ArrayList<LecturesCurriculumDTO> getCurriculumList(String lecture_title);

	void addCurriculum(CurriculumVO addCurriculumVO);

	ArrayList<String> getSectionList(int l_no);

}
