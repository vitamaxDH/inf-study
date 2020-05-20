package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;

public interface LectureService {

	ArrayList<LectureDTO> getLectureInfo(String category_name, String sort);

	LectureDetailDTO getLectureDetail(String lecture_title);

	void addLecture(UploadLectureDTO addLecture);
	
}
