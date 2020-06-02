package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.review.AllReviewDTO;
import kr.co.infStudy.dto.review.ReviewCriteria;
import kr.co.infStudy.dto.review.ReviewPageMaker;
import kr.co.infStudy.model.ReviewReplyVO;
import kr.co.infStudy.model.ReviewVO;
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

	/**
	 *  답변 달기 창 열기	 
	 */
	@GetMapping("/review/addReview")
	public String addReview(@ModelAttribute("reviewVO") ReviewVO reviewVO,
							@RequestParam(name = "l_no") int l_no,
							@RequestParam(name="lecture_title") String lecture_title,
							Model model) {

		model.addAttribute("lecture_title", lecture_title);
		model.addAttribute("l_no", l_no);
		
		return "course/addReview";
	}
	
	/**
	 * 
	 *  답변 등록	 
	 */
	@PostMapping("/review/enrollReview")
	public void enrollReview(@ModelAttribute("reviewVO") ReviewVO reviewVO) {
			
		System.out.println(reviewVO);
		reviewService.addReview(reviewVO);
	}
	
	/**
	 *  답변_답글 창 열기
	 */
	@GetMapping("/review/addReviewReply")
	public String addReviewReply(@ModelAttribute("reviewReplyVO") ReviewReplyVO reviewReplyVO,
			@RequestParam(name = "l_no") int l_no,
			@RequestParam(name="lecture_title") String lecture_title,
			@RequestParam(name = "r_no") int r_no,
			Model model) {
		
		model.addAttribute("lecture_title", lecture_title);
		model.addAttribute("l_no", l_no);
		model.addAttribute("r_no", r_no);
		
		return "course/addReviewReply";
	}
	
	/**
	 * 
	 *  답변_답글 등록하기
	 */
	@PostMapping("/review/enrollReviewReply")
	public void enrollReviewReply(@ModelAttribute("reviewReplyVO") ReviewReplyVO reviewReplyVO) {
		
		reviewReplyService.addReviewReply(reviewReplyVO);
	}

}















