package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.InstructorDAO;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO dao;
}
