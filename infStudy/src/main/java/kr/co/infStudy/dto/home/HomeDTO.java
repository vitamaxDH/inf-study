package kr.co.infStudy.dto.home;

import java.util.Date;

import lombok.Data;

@Data
public class HomeDTO {
	
	private String main_title;
	private String main_writer;
	private int main_rank;
	private String main_content;
	private String main_imageLink;
	private Date main_dt;
	private String main_category;
}