package kr.co.infStudy.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.infStudy.dao.LectureDAO;
import kr.co.infStudy.dto.lecture.LectureDTO;
import kr.co.infStudy.dto.lecture.LectureDetailDTO;
import kr.co.infStudy.dto.lecture.UploadLectureDTO;
import kr.co.infStudy.model.LectureVO;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO dao;

	/**
	 * 카테고리별 강의 조회
	 */
	@Override
	public ArrayList<LectureDTO> getLectureInfo(String category_name, String sort) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		
		hmap.put("category_name", category_name);
		hmap.put("sort", sort);
		
		return (ArrayList<LectureDTO>)dao.getLectureInfo(hmap);
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
		
		String uploadPath = "C:/Teamproject/uploadFile";
		
		MultipartFile upload_file = addLecture.getLectureImg();
		
		if(upload_file.getSize() > 0) {
			
			try {
				
				String fileName = upload_file.getOriginalFilename();
				upload_file.transferTo(new File(uploadPath + "/" + fileName));
				addLecture.setImg(fileName);
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		dao.addLecture(new LectureVO(addLecture));
		
	}
}





























