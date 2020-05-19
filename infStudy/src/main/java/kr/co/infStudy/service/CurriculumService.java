package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.lecture.LecturesCurriculumDTO;

public interface CurriculumService {

	ArrayList<LecturesCurriculumDTO> getCurriculumList(String lecture_title);

}
