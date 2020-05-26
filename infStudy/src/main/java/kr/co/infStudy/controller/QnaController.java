package kr.co.infStudy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaPageMaker;
import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.service.QnaReplyService;
import kr.co.infStudy.service.QnaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class QnaController {
	
	private QnaService qnaService;
	private QnaReplyService qnaReplyService;
	
	@Autowired
	public QnaController(QnaService qnaService, QnaReplyService qnaReplyService) {
		this.qnaService = qnaService;
		this.qnaReplyService = qnaReplyService;
	}

	@GetMapping(value="/course/{lecture_title}/questions", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArrayList<QnaDTO> getQnaList(@PathVariable String lecture_title , @RequestParam(required = false) String search){
		
		ArrayList<QnaDTO> qnaList = qnaService.getQnaList(lecture_title, search);
		
		return qnaList;
	}
	
	@GetMapping(value = "/questions/{q_no}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public QnaDTO getQnaDetail(@PathVariable int q_no){
		

		/**
		 * qna, qnaReplyList model에 담아서 뷰페이지로 넘겨주기
		 */
		QnaDTO qna = qnaService.getQnaDetail(q_no);
		ArrayList<QnaReplyDTO> qnaReplyList = qnaReplyService.getQnaReplyList(q_no);

		
		return qna;
	}

	/*나오는 데이터 값만 확인하기*/
//	@GetMapping(value = "/qna")
//	@ResponseBody
//	public ArrayList<AllQnaDTO> qna(Model model) throws Exception {
//		
//		ArrayList<AllQnaDTO> allQnaDto = qnaService.getAllQnaList();
//		
//		model.addAttribute("allQnaDto", allQnaDto);
//		return allQnaDto;
//	}
	
	/*view 페이지 호출*/
	
	@GetMapping(value = "/qna")
	public String qna(Model model, QnaCriteria cri) throws Exception {
		
		//데이터 값 뽑아오기
		ArrayList<AllQnaDTO> allQnaDto = qnaService.getAllQnaList();
		model.addAttribute("allQnaDto", allQnaDto);

		//한 페이지의 시작번호와 끝 번호
		model.addAttribute("qnaList", qnaService.qnaList(cri));
		
		//페이지네이션
		QnaPageMaker qnaPageMaker = new QnaPageMaker();
		qnaPageMaker.setCri(cri);
		qnaPageMaker.setTotalCount(qnaService.qnaListCount());
		model.addAttribute("qnaPageMaker", qnaPageMaker);
		
		return "qna";
	}
	

}
