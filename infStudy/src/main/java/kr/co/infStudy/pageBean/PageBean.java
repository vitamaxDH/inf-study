package kr.co.infStudy.pageBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hydes
 * pagination 처리를 위한 클래스
 */
@Getter
@NoArgsConstructor
public class PageBean {

	private int min;
	private int max;
	private int prevPage;
	private int nextPage;
	private int pageCnt;
	private int currentPage;
	
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		//현재 페이지 번호
		this.currentPage = currentPage;
		pageCnt = contentCnt / contentPageCnt;
		
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		
		if(currentPage < 1) currentPage = 1;
		if(currentPage > pageCnt) currentPage = pageCnt;
		
		min = ((currentPage -1) / contentPageCnt) * contentPageCnt +1;
		max = min + paginationCnt -1;
		
		if(max > pageCnt) {
			
			max = pageCnt;
		}
		
		prevPage = min-1;
		nextPage = max+1;
		
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		
	}
}
