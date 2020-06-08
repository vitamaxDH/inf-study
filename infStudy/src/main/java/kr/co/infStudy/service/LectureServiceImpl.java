package kr.co.infStudy.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.infStudy.dao.LectureDAO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.MyLecturesDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.LectureVO;
import kr.co.infStudy.model.UsersVO;
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
	private final CategoryService categoryDao;
	
	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Lazy
	@Resource(name = "login")
	private UsersVO login;
	

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
		
		LectureDetailDTO lectureDetail = dao.getLectureDetail(lecture_title);
					
		if(login.getI_no() == lectureDetail.getI_no()) {
			login.setAuth("instructor");
		}else if(login.getClassList().contains(lectureDetail.getL_no())) {
			login.setAuth("student");
		}else {
			login.setAuth(null);
		}

		return lectureDetail;
	}
	

	/**
	 * 강의 등록 
	 * 트렌젝션 걸기
	 */
	@Override
	@Transactional
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
		//스트림
		/*
		 * 1. DB를 조회해서 categoryVO를 List로 뽑아낸다.
		 * 2. stream()을 돌면서 categoryVO에서 categoryVO의 ctg_no를 매핑한다.(ctg_no만을 뽑아낸다.)
		 * 3. ctg_no를 List로 만든다.
		 * 4. 이렇게 해서 만들어진 List가 addLecture로 넘어온 ctg_no를 포함하고 있는지 확인한다.
		 */
		if(!categoryDao.getCategoryList().stream()
  										 .map(o->o.getName())
										 .collect(Collectors.toList()).contains(addLecture.getCtg_name())) {

			categoryDao.addCategory(addLecture.getCtg_name());
		}
		//Transaction Test
		//System.out.println(1/0);
		dao.addLecture(new LectureVO(addLecture));		
	}
	
	/**
	 * 페이징 처리
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
	
	/**
	 * 수강 중인 강의 리스트 불러오기
	 */
	@Override
	public ArrayList<MyLecturesDTO> getMyLectureInfo(int u_no, String lecture_title, int page) throws Exception {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("u_no", String.valueOf(u_no));
		hmap.put("lecture_title", lecture_title);
		
		int start = (page-1)*page_listcnt;
		
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		return (ArrayList<MyLecturesDTO>) dao.getMyLectureInfo(hmap, rowBounds);
	}
	
	@Override
	public PageBean getMyLectureCnt(int u_no, int currentPage) {
		
		int content_cnt = dao.getMyLectureCnt(u_no);
		
		return new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
	}
	
	/**
	 * 강의 제목 중복 체크
	 */
	@Override
	public String chkTitle(String lecture_title) {
		
		if(dao.chkTitle(lecture_title) != null) {
			return "occupied";
		}else {
			return "available";
		}	
	}
}





























