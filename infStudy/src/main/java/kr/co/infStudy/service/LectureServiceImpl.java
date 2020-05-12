package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.LectureDAO;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO dao;
}
