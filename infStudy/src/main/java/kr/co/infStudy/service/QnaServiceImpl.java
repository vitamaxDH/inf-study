package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO dao;
}
