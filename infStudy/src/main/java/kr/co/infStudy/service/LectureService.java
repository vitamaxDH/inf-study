package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.LectureDTO;

public interface LectureService {

	ArrayList<LectureDTO> getAllLectureInfo();

	ArrayList<LectureDTO> getLectureByCategory(String category_name, String sort);

}
