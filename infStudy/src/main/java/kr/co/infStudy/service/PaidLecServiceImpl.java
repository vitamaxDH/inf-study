package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.PaidLecDAO;

@Service
public class PaidLecServiceImpl implements PaidLecService {

	@Autowired
	private PaidLecDAO dao;
}
