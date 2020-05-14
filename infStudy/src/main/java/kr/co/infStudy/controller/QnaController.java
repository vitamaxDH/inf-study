package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.service.QnaReplyService;
import kr.co.infStudy.service.QnaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class QnaController {
	
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private QnaReplyService qnaReplyService;
	
	@GetMapping(value="/course/{lecture_title}/questions", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<QnaDTO> getQnaList(@PathVariable String lecture_title , @RequestParam(required = false) String search){
		
		ArrayList<QnaDTO> qnaList = qnaService.getQnaList(lecture_title, search);
		
		return qnaList;
	}
	
	@GetMapping(value = "/questions/{q_no}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<QnaReplyDTO> getQnaDetail(@PathVariable String q_no){
		

		/**
		 * qna, qnaReplyList model에 담아서 뷰페이지로 넘겨주기
		 */
		QnaDTO qna = qnaService.getQnaDetail(q_no);
		ArrayList<QnaReplyDTO> qnaReplyList = qnaReplyService.getQnaReplyList(q_no);

		
		return qnaReplyList;
	}
	

}
