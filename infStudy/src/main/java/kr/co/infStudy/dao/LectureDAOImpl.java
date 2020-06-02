package kr.co.infStudy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.MyLecturesDTO;
import kr.co.infStudy.model.LectureVO;

@Repository
public class LectureDAOImpl implements LectureDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.lectureMapper.";

	/**
	 * 강의들 페이지의 강의 목록 불러오기
	 */
	@Override
	public List<LectureDTO> getLectureInfo(HashMap<String, String> hmap, RowBounds rowBounds) {

		return session.selectList(nameSpace + "getLectureInfo", hmap, rowBounds);
	}

	/**
	 * 강의 상세 내용 조회
	 */
	@Override
	public LectureDetailDTO getLectureDetail(String lecture_title) {

		return session.selectOne(nameSpace + "getLectureDetail", lecture_title);
	}

	/**
	 * 강의 등록
	 */
	@Override
	public void addLecture(LectureVO lectureVO) {

		session.insert(nameSpace + "addLecture", lectureVO);
	}

	/**
	 * 수강 중인 강의
	 */
	@Override
	public List<MyLecturesDTO> getMyLectureInfo(HashMap<String, String> hmap, RowBounds rowBounds) throws Exception {
		return session.selectList(nameSpace + "getMyLectureInfo", hmap, rowBounds);
	}
	
	/**
	 * ?????
	 */
	@Override
	public List<String> getLectureFileNames(HashMap<String, String> hmap) {
		return session.selectList(nameSpace + "getLectureFileNames", hmap);
	}

	/**
	 * 페이징
	 */
	@Override
	public int getLectureCnt(HashMap<String, String> hmap) {
		return session.selectOne(nameSpace + "getLectureCnt", hmap);
	}
	/**
	 * 수강 중인 강의 페이징
	 */
	@Override
	public int getMyLectureCnt(int u_no) {
		
		return session.selectOne(nameSpace + "getMyLectureCnt", u_no);
	}

}
