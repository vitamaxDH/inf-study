package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;

public interface LectureService {

	ArrayList<LectureDTO> getLectureInfo(String category_name, String sort);

	ArrayList<LectureDetailDTO> getLectureDetail(String lecture_title);

}
