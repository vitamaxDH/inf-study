<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/profile.css" rel="stylesheet">
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
					<a href="profile"><li class="listContent_selected"><span class="glyphicon glyphicon-user"></span> 내 프로필 보기</li></a>
					<a href="myLecture"><li class="listContent"><span class="glyphicon glyphicon-tasks"></span> 수강중인 강의</li></a>
					<a href="myQnA"><li class="listContent"><span class="glyphicon glyphicon-comment"></span> 내 질문 답변</li></a>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="contentContainer">
				
					<div class="box pofile-box-head">프로필 설정</div>
					<div class="box"></div>
					<form class="box box-sd pofile-box">
						<p>닉네임</p>
				          <label for="exampleInputEmail1">닉네임</label>
				          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="닉네임을 입력하세요">
					      <button type="submit" class="btn btn-default submitBtn">저장하기</button>
					</form>
					<div class="box"></div>
					<form class="box box-sd pofile-box">
						<p>이메일</p>
				        <label for="exampleInputEmail1">이메일</label>
				        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="이메일을 입력하세요">
						<button type="submit" class="btn btn-default submitBtn">저장하기</button>
				   	</form>
				   	<div class="box"></div>
					<div class="box box-sd">
				        <form class="pofile-box">
				        	<p>비밀번호<p>
					        <div class="form-group">
					          <label for="exampleInputPassword1">현재 비밀번호</label>
					          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="암호">
					        </div>
					        <div class="form-group">
					          <label for="exampleInputPassword1">새 비밀번호</label>
					          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="암호">
					        </div>
					        <div class="form-group">
					          <label for="exampleInputPassword1">비밀번호 확인</label>
					          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="암호">
					        </div>
					        <button type="submit" class="btn btn-default submitBtn">저장하기</button>
					    </form>
				    </div>
				    <div class="box"></div>
					<div class="box box-sd pofile-box">
						<p><a href="#">탈퇴하기</a></p>
					</div>
					<div class="box"></div>
                </div>
            </div>
        </div>
	</div>
</body>
</html>
