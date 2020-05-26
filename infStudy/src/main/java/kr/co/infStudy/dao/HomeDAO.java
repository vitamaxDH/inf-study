package kr.co.infStudy.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.infStudy.dto.home.HomeDTO;

public interface HomeDAO {

	List<HomeDTO> getHomeList(HashMap<String, String> hmap);

}
