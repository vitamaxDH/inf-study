package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import kr.co.infStudy.dto.lecture.AddCurriculumDTO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.MyLecturesDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.CurriculumVO;
import kr.co.infStudy.pageBean.PageBean;

public interface LectureService {

	ArrayList<LectureDTO> getLectureInfo(String category_name, String sort, String lecture_title , int page);
	/**
	 *  강의 상세 조회
	 */
	LectureDetailDTO getLectureDetail(String lecture_title);

	void addLecture(UploadLectureDTO addLecture);
		
	//오늘 날짜 구하는 메서드
	public String getToday();
	
	//파일을 저장할 폴더 만들기
	void makeFolder(String rootPath, String remainPath);	
	
	// 전체 강의 조회를 위한 페이징 처리
	public PageBean getLectureCnt(String lecture_title, int currentPage);
	
	// 나의 강의 조회
	ArrayList<MyLecturesDTO> getMyLectureInfo(int u_no, String lecture_title, int page) throws Exception;
	
	// 나의 강의 조회를 위한 페이징 처리
	PageBean getMyLectureCnt(int u_no, int page);

}
