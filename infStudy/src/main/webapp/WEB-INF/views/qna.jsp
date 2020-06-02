<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q n A</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
</head>
<body>
	<div class="qnaBody">
		<div class="qnaHeader">
			<div class="qnaHeaderDiv">
				<h1>묻고 답해요.</h1>
				<p>모두가 함께하는 커뮤니티</p>
				<p>모르면 묻고, 해답을 찾아보세요.</p>
			</div>
		</div>
		<div class="qnaMain">
			<div class="qnaNavi">
				<ul>
					<li class="listTitle">함께 공부해요</li>
					<a href="qna"><li class="listContent_selected"><span
							class="glyphicon glyphicon-comment"></span> 묻고 답하기</li></a>
					<a href="review"><li class="listContent"><span
							class="glyphicon glyphicon-star"></span> 수강평 모아보기</li></a>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="qnaBoqrdHeader">
					<div class="alignList">
						<select name="alignList" class="alignList_select"  onchange="sort(this.form)">
							<option value="qna_reg_dt" <c:if test="${col=='qna_reg_dt' }">selected</c:if>>최신순</option>
							<option value="qr_count" <c:if test="${col=='qr_count' }">selected</c:if>>답변순</option>
							<option value="qr_count" <c:if test="${col=='qr_count' }">selected</c:if>>미답변순</option>
						</select>
					</div>
					<div class="searchBox">
						<div class="searchBoxDiv">
							<input type="text">
							<button>검색</button>
						</div>
					</div>
				</div>
				<div class="contentContainer">
					<c:forEach var="list" items="${allQnaDto}" begin="${qnaPageMaker.cri.rowStart}" end="${qnaPageMaker.cri.rowEnd}">
						<div class="contentList">
							<div class="contentLeft">
								<div class="qnaTitle">
									<a href="${root }/questions/${list.q_no}"><span>Q. </span> ${list.qna_title}</a>
								</div>
								<div class="qnaDetail">
									<span>글쓴이 : ${list.qna_writer}</span> 
									<span>시간 : ${list.qna_reg_dt}</span> 
									<span>강의명 : ${list.lec_title}</span>
								</div>
							</div>
							<div class="contentRignt">
								<div class="ansqered">
									<c:if test="${list.qr_count!=0 }">
										답변 : ${list.qr_count}개
									</c:if>
									<c:if test="${list.qr_count==0 }">
										미답변
									</c:if>
								</div>
								<div class="qnaLink">
									<button>질문으로 가기</button>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="qnaBoqrdPaging">
						<nav>
							<ul class="pagination">
								
								<!-- 맨 처음 화면으로 -->
								<c:if test="${qnaPageMaker.cri.page>10}">
									<li>
										<a href="qna?page=1&perPageNum=10"> 
											start
										</a>
									</li>
								</c:if>
								
								<!-- 이전화면 -->
								<c:if test="${qnaPageMaker.prev}">
									<li>
										<a href="qna${qnaPageMaker.makeQuery(qnaPageMaker.startPage - 1)}" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:if>
								
								<!-- 페이지 선택 -->
								<c:forEach begin="${qnaPageMaker.startPage}" end="${qnaPageMaker.endPage}" var="idx">
							    	<c:if test="${idx eq qnaPageMaker.cri.page}">
							    		<li><a href="qna${qnaPageMaker.makeQuery(idx)}" style="background-color:rgb(0,196,113); color:white;">${idx}</a></li>
							    	</c:if>
							    	<c:if test="${idx ne qnaPageMaker.cri.page}">
							    		<li><a href="qna${qnaPageMaker.makeQuery(idx)}">${idx}</a></li>
							    	</c:if>
							    </c:forEach>
							    
								<!-- 다음화면 -->
							    <c:if test="${qnaPageMaker.next && qnaPageMaker.endPage > 0}">
							    	<li>
							    		<a href="qna${qnaPageMaker.makeQuery(qnaPageMaker.endPage + 1)}" aria-label="Next">
							    			<span aria-hidden="true">&raquo;</span>
							    		</a>
							    	</li>
							    </c:if> 
							    
								<!-- 맨 마지막 화면으로 -->
							    <c:if test="${qnaPageMaker.endPage != qnaPageMaker.totalEndPage}">
									<li>
										<a href="qna?page=${qnaPageMaker.totalEndPage}&perPageNum=${qnaPageMaker.cri.perPageNum}"> 
											end
										</a>
									</li>
							    </c:if> 
								
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
