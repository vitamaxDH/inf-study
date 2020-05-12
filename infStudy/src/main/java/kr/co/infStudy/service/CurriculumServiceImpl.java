package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.CurriculumDAO;

@Service
public class CurriculumServiceImpl implements CurriculumService {

	@Autowired
	private CurriculumDAO dao;
}
