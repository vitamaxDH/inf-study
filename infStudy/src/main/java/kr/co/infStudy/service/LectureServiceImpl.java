package kr.co.infStudy.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.infStudy.dao.LectureDAO;
import kr.co.infStudy.dto.lecture.AddCurriculumDTO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.CurriculumVO;
import kr.co.infStudy.model.LectureVO;
import kr.co.infStudy.pageBean.PageBean;
import lombok.RequiredArgsConstructor;
/**
 * 
 * @author hydes
 * Lecture 테이블의 CRUD와 관련된 Service
 */
@Service
@RequiredArgsConstructor
@PropertySource("/WEB-INF/properties/option.properties")
public class LectureServiceImpl implements LectureService {
	
	private final LectureDAO dao;	
	private final CurriculumService curriculumService;
	
	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	

	/**
	 * 카테고리별 강의 조회
	 */
	@Override
	public ArrayList<LectureDTO> getLectureInfo(String category_name, String sort, String lecture_title , int page) {
		
		int start = (page -1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		
		hmap.put("category_name", category_name);
		hmap.put("sort", sort);
		hmap.put("lecture_title", lecture_title);
		
		return (ArrayList<LectureDTO>)dao.getLectureInfo(hmap, rowBounds);
	}
	
	/**
	 *  강의 상세 조회
	 */
	@Override
	public LectureDetailDTO getLectureDetail(String lecture_title) {
		
		return dao.getLectureDetail(lecture_title);
	}
	

	/**
	 * 강의 등록 
	 */
	@Override
	public void addLecture(UploadLectureDTO addLecture) {
		
		MultipartFile upload_file = addLecture.getLectureImg();		

		if(upload_file.getSize() > 0) {

			String rootPath = "C:/Teamproject/uploadFile";		// 파일 저장할 기본 경로
			String remainPath = "/lectureImg";					// 나머지 경로
			makeFolder(rootPath, remainPath);					// 기본 경로 > 나머지 경로 > 업로드 날짜의 폴더 생성
			
			// 확장자명 구하기
			String orgName = upload_file.getOriginalFilename();		// 원본 파일 이름 구하기
			String ext = orgName.substring(orgName.lastIndexOf(".")+1);	// 원본 파일에서 확장자명 구하기
			
			//저장할 파일 이름 지정
			String fileName = remainPath + "/" + getToday() + "/" + addLecture.getTitle() + "." + ext;
			
			//임의의 파일명 생성
			File saveFile = new File(rootPath + fileName);
			
			try {
				
				upload_file.transferTo(saveFile);	// 오늘날짜 폴더 안에 파일 생성
				addLecture.setImg(fileName);		// addLecture에 Img값 설정
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		dao.addLecture(new LectureVO(addLecture));		
	}
	
	/**
	 * 
	 */
	@Override
	public PageBean getLectureCnt(String category_name, int currentPage) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("category_name", category_name);
		
		int content_cnt = dao.getLectureCnt(hmap);
				
		return new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
	}
	
	
	
	/**
	 * 오늘 날짜를 구하는 메서드
	 */
	@Override
	public String getToday() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(c.getTime());
	}
	
	/**
	 *  폴더 생성 메서드
	 */
	@Override
	public void makeFolder(String rootPath, String remainPath) {
		// uploadFile 폴더에 lectureImg가 있는지 확인한다
		File lectureImgFolder = new File(rootPath + remainPath);
		if(!lectureImgFolder.isDirectory()) lectureImgFolder.mkdir();	//lectureImg폴더가 없으면 폴더를 생성한다.
		
		// 오늘 날짜의 폴더가 있는지 확인한다.
		File todayFoloder = new File(rootPath + remainPath + "/" + getToday());
		if(!todayFoloder.isDirectory()) todayFoloder.mkdir();			//오늘 날짜의 폴더가 없으면 폴더를 생성한다.
	}
	
	
}





























