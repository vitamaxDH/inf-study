<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
</head>
<body>
	 <div class="qnaBody">
		<div class="qnaHeader">
            <div class="qnaHeaderDiv">
                <h1>수강평</h1>
                <p>모두가 함께하는 커뮤니티</p>
                <p>실시간으로 올라오는 진짜 수강평!!</p>
            </div>
        </div>
		<div class="qnaMain">
			<div class="qnaNavi">
				<ul>
					<li class="listTitle">함께 공부해요</li>
					<a href="qna"><li class="listContent"><span class="glyphicon glyphicon-comment"></span> 묻고 답하기</li></a>
					<a href="review"><li class="listContent_selected"><span class="glyphicon glyphicon-star"></span> 수강평 모아보기</li></a>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="contentContainer">
					<c:forEach var="list" items="${allReviewDto}" begin="${reviewPageMaker.cri.rowStart }" end="${reviewPageMaker.cri.rowEnd }">
						<div class="reView_contentList">
							<div class="reView_contentLeft">
								<div class="reView_qnaTitle">
									<div class="reView_star">
										<c:forEach begin="1" end="${list.review_rank}">
											★&nbsp; 
										</c:forEach>
										<c:forEach begin="1" end="${5 - list.review_rank}">
											☆&nbsp;
										</c:forEach>
									</div>
									<div class="reView_content">${list.review_content}</div>
								</div>
								<div class="reView_qnaDetail">
									<span>글쓴이 : ${list.review_writer}</span>
									<span>시간 : ${list.review_dt}</span>
                                    <span>강의명 : ${list.review_dt}</span>
								</div>
							</div>
							<div class="reView_contentRignt" style="background-image: url('images/back1.png');"></div>
						</div>

                    </c:forEach>
                    <div class="qnaBoqrdPaging">
                        <nav>
                            <ul class="pagination">
                            
								<!-- 맨 처음 화면으로 -->
								<c:if test="${reviewPageMaker.cri.page>10}">
									<li>
										<a href="review?page=1&perPageNum=10"> 
											start
										</a>
									</li>
								</c:if>
								
								<!-- 이전화면 -->
								<c:if test="${reviewPageMaker.prev}">
									<li>
										<a href="review${reviewPageMaker.makeQuery(reviewPageMaker.startPage - 1)}" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:if>
								
								<!-- 페이지 선택 -->
								<c:forEach begin="${reviewPageMaker.startPage}" end="${reviewPageMaker.endPage}" var="idx">
							    	<c:if test="${idx eq reviewPageMaker.cri.page}">
							    		<li><a href="review${reviewPageMaker.makeQuery(idx)}" style="background-color:rgb(0,196,113); color:white;">${idx}</a></li>
							    	</c:if>
							    	<c:if test="${idx ne reviewPageMaker.cri.page}">
							    		<li><a href="review${reviewPageMaker.makeQuery(idx)}">${idx}</a></li>
							    	</c:if>
							    </c:forEach>
							    
								<!-- 다음화면 -->
							    <c:if test="${reviewPageMaker.next && reviewPageMaker.endPage > 0}">
							    	<li>
							    		<a href="review${reviewPageMaker.makeQuery(reviewPageMaker.endPage + 1)}" aria-label="Next">
							    			<span aria-hidden="true">&raquo;</span>
							    		</a>
							    	</li>
							    </c:if> 
							    
								<!-- 맨 마지막 화면으로 -->
							    <c:if test="${reviewPageMaker.endPage != reviewPageMaker.totalEndPage}">
									<li>
										<a href="review?page=${reviewPageMaker.totalEndPage}&perPageNum=${reviewPageMaker.cri.perPageNum}"> 
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
