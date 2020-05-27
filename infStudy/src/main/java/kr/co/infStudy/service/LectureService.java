package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.infStudy.dto.lecture.AddCurriculumDTO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.CurriculumVO;
import kr.co.infStudy.pageBean.PageBean;

public interface LectureService {

	ArrayList<LectureDTO> getLectureInfo(String category_name, String sort, String lecture_title , int page);

	LectureDetailDTO getLectureDetail(String lecture_title);

	void addLecture(UploadLectureDTO addLecture);
		
	//오늘 날짜 구하는 메서드
	public String getToday();
	
	//파일을 저장할 폴더 만들기
	void makeFolder(String rootPath, String remainPath);	
	
	public PageBean getLectureCnt(String lecture_title, int currentPage);

}
