package kr.co.infStudy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.MyLecturesDTO;
import kr.co.infStudy.model.LectureVO;

public interface LectureDAO {

	List<LectureDTO> getLectureInfo(HashMap<String, String> hmap, RowBounds rowBounds);

	LectureDetailDTO getLectureDetail(String lecture_title);

	void addLecture(LectureVO lectureVO);

	List<String> getLectureFileNames(HashMap<String, String> hmap);
	
	int getLectureCnt(HashMap<String, String> hmap);

	//수강 중인 강의 리스트 가져오기
	List<MyLecturesDTO> getMyLectureInfo(HashMap<String, String> hmap, RowBounds rowBounds) throws Exception;
	
	//수강 중인 강의 수 구하기
	int getMyLectureCnt(int u_no);
	
	//강의 제목 중복 체크
	String chkTitle(String lecture_title);


}
