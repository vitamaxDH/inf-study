package kr.co.infStudy.service;

import java.util.ArrayList;

import kr.co.infStudy.dto.home.HomeDTO;

public interface HomeService {

	ArrayList<HomeDTO> getHomeList(String order);

}
