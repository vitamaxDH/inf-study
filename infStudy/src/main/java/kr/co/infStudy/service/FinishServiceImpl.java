package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.FinishDAO;

@Service
public class FinishServiceImpl implements FinishService {

	@Autowired
	private FinishDAO dao;
}
