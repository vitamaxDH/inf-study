package kr.co.infStudy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infStudy.dao.HomeDAO;
import kr.co.infStudy.dto.home.HomeDTO;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDAO dao;

@Override
	public ArrayList<HomeDTO> getHomeList(String order) {
	
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("order", order);
		
		return  (ArrayList<HomeDTO>) dao.getHomeList(hmap);
	}	


}
