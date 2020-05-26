package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infStudy.dto.home.HomeDTO;

@Repository
public class HomeDAOImpl implements HomeDAO {

	@Autowired
	private SqlSession session;
	private String nameSpace = "kr.co.infStudy.homeMapper.";
	

	@Override
	public List<HomeDTO> getHomeList(HashMap<String, String> hmap) {
		
		return session.selectList(nameSpace + "getHomeList", hmap);
	}
}
