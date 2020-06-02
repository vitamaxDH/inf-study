<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myQnA</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/myQnA.css" rel="stylesheet">
</head>
<body>
	 <div class="qnaBody">
		<div class="qnaHeader">
            <div class="qnaHeaderDiv">
                <h1>나의 프로필</h1>
                <p>모두가 함께하는 커뮤니티</p>
                <p>InfStudy에서 함께 공부해요</p>
            </div>
        </div>
		<div class="qnaMain">
			<div class="qnaNavi">
				<ul>
					<li class="listTitle">함께 공부해요</li>
					<a href="profile"><li class="listContent"><span class="glyphicon glyphicon-user"></span> 내 프로필 보기</li></a>
					<a href="myLecture"><li class="listContent"><span class="glyphicon glyphicon-tasks"></span> 수강중인 강의</li></a>
					<a href="myQnA"><li class="listContent_selected"><span class="glyphicon glyphicon-comment"></span> 내 질문 답변</li></a>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="contentContainer">
				
					<div class="box qnaBoard-head"><p>내 질문</p></div>
					
					<div class="box">
						<div class="searchBox">
							<form class="searchBoxDiv" role="form" method="get">
								<input type="text" name="keyword" id="keywordInput" value="${scri.keyword }">
								<button type="button" id="searchBtn">검색</button>
								<script>
							      $(function(){
							        $('#searchBtn').click(function() {
							          self.location = "qna" + '${pageMaker.makeQuery(1)}' + "?keyword=" + encodeURIComponent($('#keywordInput').val());
							        });
							      });   
							    </script>
							</form>
						</div>
					</div>
				
					<div class="box list-box">
						<c:forEach var="list" items="${myQnaDto}" begin="${qnaPageMaker.cri.rowStart}" end="${qnaPageMaker.cri.rowEnd}">
							<div class="contentList">
								<div class="contentLeft">
									<div class="qnaTitle">
										<a href="${pageContext.request.contextPath }/questions/${list.q_no}"><span>Q. </span> ${list.qna_title}</a>
									</div>
									<div class="qnaDetail">
										<span>글쓴이 : ${list.qna_writer}</span> 
										<span>시간 : ${list.qna_reg_dt}</span> 
										<span>강의명 : ${list.lec_title}</span>
									</div>
								</div>
								<div class="contentRignt">
									<div class="ansqered"></div>
									<div class="qnaLink">
										<button>질문으로 가기</button>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="box qnaBoqrdPaging">
							<nav>
								<ul class="pagination">
									
									<!-- 이전화면 -->
									<c:if test="${qnaPageMaker.prev}">
										<li><a href="myQnA?page=1&perPageNum=10">start</a></li>
										<li><a href="myQnA${qnaPageMaker.makeSearch(qnaPageMaker.startPage - 1)}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
									</c:if>
									
									<!-- 페이지 선택 -->
									<c:forEach begin="${qnaPageMaker.startPage}" end="${qnaPageMaker.endPage}" var="idx">
								    	<c:if test="${idx eq qnaPageMaker.cri.page}">
								    		<li><a href="myQnA${qnaPageMaker.makeSearch(idx)}" style="background-color:rgb(0,196,113); color:white;">${idx}</a></li>
								    	</c:if>
								    	<c:if test="${idx ne qnaPageMaker.cri.page}">
								    		<li><a href="myQnA${qnaPageMaker.makeSearch(idx)}">${idx}</a></li>
								    	</c:if>
								    </c:forEach>
								    
									<!-- 다음화면 -->
								    <c:if test="${qnaPageMaker.next && qnaPageMaker.endPage > 0}">
								    	<li><a href="myQnA${qnaPageMaker.makeSearch(qnaPageMaker.endPage + 1)}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
										<li><a href="myQnA?page=${qnaPageMaker.totalEndPage}&perPageNum=${qnaPageMaker.cri.perPageNum}">end</a></li>
								    </c:if> 
									
								</ul>
							</nav>
						</div>
					</div>
				
				
					
                </div>
            </div>
        </div>
	</div>
</body>
</html>
