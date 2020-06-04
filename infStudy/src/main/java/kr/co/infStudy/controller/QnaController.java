package kr.co.infStudy.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.infStudy.dto.qna.AllQnaDTO;
import kr.co.infStudy.dto.qna.QnaCriteria;
import kr.co.infStudy.dto.qna.QnaDTO;
import kr.co.infStudy.dto.qna.QnaPageMaker;
import kr.co.infStudy.dto.qna.QnaReplyDTO;
import kr.co.infStudy.model.QnaReplyVO;
import kr.co.infStudy.model.QnaVO;
import kr.co.infStudy.model.ReviewVO;
import kr.co.infStudy.model.UsersVO;
import kr.co.infStudy.service.LectureService;
import kr.co.infStudy.service.QnaReplyService;
import kr.co.infStudy.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class QnaController {
	
	private final QnaService qnaService;
	private final QnaReplyService qnaReplyService;
	private final LectureService lectureService;
	
	@Resource(name = "login")
	@Lazy
	private UsersVO login;
	
	@GetMapping(value="/course/{lecture_title}/questions", produces = "application/json; charset=utf-8")
	public String getQnaList(@PathVariable String lecture_title, 
							 @RequestParam(required = false) String search,
							 @ModelAttribute("qna") QnaVO qna,
							 @ModelAttribute("qnaReply") QnaReplyVO qnaReply,
							 Model model){
		
		model.addAttribute("qnaList", qnaService.getQnaList(lecture_title, search));
		model.addAttribute("lectureDetail", lectureService.getLectureDetail(lecture_title));
		model.addAttribute("auth", login.getAuth());			

		
		return "course/lectureQna";
	}
	
	/**
	 * 질문 상세보기
	 */
	@GetMapping(value = "/questions/{q_no}", produces = "application/json; charset=utf-8")
	public String getQnaDetail(@PathVariable int q_no,
							   Model model){
		
		/**
		 * qna, qnaReplyList model에 담아서 뷰페이지로 넘겨주기
		 */
		QnaDTO qna = qnaService.getQnaDetail(q_no);
		ArrayList<QnaReplyDTO> qnaReplyList = qnaReplyService.getQnaReplyList(q_no);
		
		model.addAttribute("qna", qna);
		model.addAttribute("qnaReplyList", qnaReplyList);
		
		return "course/qnaDetail";
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
		ArrayList<AllQnaDTO> allQnaDto = qnaService.getAllQnaLists();
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
	
	@GetMapping(value = "/qna/addQna")
	public String gotoAddQnaPg(Model model, 
			 				 @RequestParam("lecture_title") String lecture_title,
			 				 @RequestParam("l_no") int l_no,
			 				 @ModelAttribute("qnaVO") QnaVO qnaVO) {
		
		model.addAttribute("l_no", l_no);
		model.addAttribute("lecture_title", lecture_title);
		
		return "course/addQnaPg";
	}
	
	/**
	 * 
	 * 질문 등록하기
	 */
	@PostMapping(value = "/qna/enrollQna")
	public String enrollQna(@ModelAttribute("qnaVO") QnaVO qnaVO,
							@RequestParam("lecture_title") String lecture_title) {
		
		qnaService.addQna(qnaVO);
		
		return "redirect:/course/" + lecture_title + "/questions";
	}
	
	@PostMapping(value = "/qna/enrollQnaReply")
	public String enrollQnaReply(@ModelAttribute("qnaReply") QnaReplyVO qnaReply,
								 @RequestParam("lecture_title") String lecture_title) {
		
		System.out.println(qnaReply);
		qnaReplyService.addQnaReply(qnaReply);
		System.out.println("QnAReply 등록 완료!!!");
		
		return "redirect:/course/" + lecture_title + "/questions";
	}


}




















