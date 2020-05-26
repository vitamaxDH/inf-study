package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;
import kr.co.infStudy.dto.review.ReviewPageMaker;
import kr.co.infStudy.service.ReviewReplyService;
import kr.co.infStudy.service.ReviewService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewReplyService reviewReplyService;

	
	@GetMapping(value = "/review")
	public String review(Model model, ReviewCriteria cri) throws Exception {
		
		ArrayList<AllReviewDTO> allReviewDto = reviewService.getAllReviewList();
		model.addAttribute("allReviewDto", allReviewDto);
		
		//페이지네이션
		ReviewPageMaker reviewPageMaker = new ReviewPageMaker();
		reviewPageMaker.setCri(cri);
		reviewPageMaker.setTotalCount(reviewService.reviewListCount());
		model.addAttribute("reviewPageMaker", reviewPageMaker);
		return "review";
	}
	

	//test용 코드
	@GetMapping(value = "/reviewTest")
	@ResponseBody
	public ArrayList<AllReviewDTO> reviewTest(Model model) throws Exception {
		
		ArrayList<AllReviewDTO> allReviewDto = reviewService.getAllReviewList();
		
		model.addAttribute("allReviewDto", allReviewDto);
		return allReviewDto;
	}
	

}
