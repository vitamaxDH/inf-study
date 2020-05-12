package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.UsersDAO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO dao;
}
