<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<a href="/dashboard">
		<li>대시보드</li>
	</a>
	<a href="/my-courses">
		<li class="menu">내 학습
			<ul>
				<li><a href="/my-courses">수강중인 강의</a></li>
				<li><a href="/my-questions">내 질문</a></li>
			</ul>
		</li>
	</a>
	<a href="/wishList">
		<li class="menu">내 결제
			<ul>
				<li><a href="/wishList">위시리스트</a></li>
				<li><a href="/paidLecList">구매 내역</a></li>
			</ul>
		</li>
	</a>
	<a href="/setting">
		<li class="menu">프로필 설정</li>
	</a>
</ul>