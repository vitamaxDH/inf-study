package kr.co.infStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.WishListDAO;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListDAO dao;
}
