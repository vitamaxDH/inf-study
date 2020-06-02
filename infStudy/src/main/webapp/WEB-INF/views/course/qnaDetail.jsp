<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%-- <%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main id="main">
	<section>
		<div class="container">
			<div class="question_header">
				<div class="column">
					<h1 class="title">${qna.qna_title }</h1>
				</div>
			</div>
			<div class="question_body">
				<div class="question_container">
					<div class="question">
						<div class="question_detail">
							<figure class="writer_img">
								<img src="${qna.qna_writer_img }" alt="" />
							</figure>
							<div class="question_content">
								<div class="question_writer">
									<h1 id="writer">작성자 : ${qna.qna_writer} <small>작성일 : ${qna.qna_reg_date }</small></h1>
								</div>
								<div class="question_body">
									${qna.qna_content }
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="reply_container">
					<div class="replies">
						<c:forEach var="reply" items="${qnaReplyList }">
							<div class="reply_detail">
								<figure class="replier_img">
									<img src="${reply.reply_writer_img }" alt="" />
								</figure>
								<div class="question_content">
									<div class="question_writer">
										<h1 id="writer">작성자 : ${reply.reply_writer} <small>작성일 : ${reply.reply_reg_dt }</small></h1>
									</div>
									<div class="question_content_body">
										${reply.reply_content}
									</div>
								</div>
							</div>						
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
	</section>
</main>

<link href="/resources/common/css/courseCss/qnaDetail.css" rel="stylesheet">

</body>
</html>