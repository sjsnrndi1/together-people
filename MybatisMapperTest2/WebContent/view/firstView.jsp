<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOGETHER PEOPLE</title>
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<script>						
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
</script>
<style>
	.contentBar {
		width : 50%;
		height : 600px;
		background-color : #FFFFFF;
		margin-left : 25%;
		color : #696969;
		font-family: 'Hanna';
		overflow : auto;
		-ms-overflow-style: none;
		scrollbar-width: none;
		padding-bottom : 1%;
	}
	.contentBar::-webkit-scrollbar {
		display: none;
	}
	.contentBar a:link { color : #696969; }
	.contentBar a:visited { color : #696969; }
	.contentBar a:hover { color : #696969; }
	.contentBar a:black { color : #696969; }
	
	.realtimePosting {
		border : 1px;
		width : 99%;
		height : 190px;
		font-family: 'Hanna';
	}
	
	.userImgCir {
		width : 35px;
		height : 35px;
		border-radius : 70%;
		overflow : hidden;
		background: #BDBDBD;
		float : left;
	}
	
	.userImg {
		width : 100%;
		height : 100%;
		object-fit: cover;
	}
	
	.postingName {
		overflow: hidden;
    	text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 3; /* 라인수 */
		-webkit-box-orient: vertical;
		word-wrap:break-word;
		line-height: 1.2em;
  		height: 3.6em; /* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
	}
	.postingView {
		font-size : 140%;
		width : 100%;
		float : left;
		height : auto;
		margin-left : 25%;
		padding-top : 1%;
		color : #696969;
	}
</style>
</head>
<body>
	<div class = "titleBar">
		<div class="dropmenu">
			<ul>
				<li><a href="firstView">TogetherPeople</a></li>
				<li><a href="noticeView" id="current">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					<ul>
						<li><a href="noticeView">CEO</a></li>
						<li><a href="noticeAccessView">ACCESS</a></li>
					</ul>
				</li>
				<li><a href="boardView">공지사항</a></li>
				<li><a href="mypageView">커뮤니티</a></li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><a href="loginView">로그인</a></li>
				<li><a href="userRegist">회원가입</a></li>
				<li><a href ="#" class="openmenu" onclick='openNav()' style = "font-size : 100%;">전체메뉴</a></li>
			</ul>
		</div>
		
		<div id="mysidenav" class="sidenav">
			<a href="firstView">Together People</a>
			<a href="#" class="closebtn" onclick='closeNav()'>x</a>
			<a href="noticeView">소개</a>
			<a href="boardView">공지사항</a>
			<a href="mypageView">커뮤니티</a>			
		</div>					
	</div>
<!-- 실시간 포스팅 / 공지사항 / 이용후기 / 진행중인 모임 -->
	<div class = "postingView">
		포스팅<small style = "font-size : 70%;">(당신의 일상을 모두와 자유롭게 공유하세요.)</small>
	</div>
	<div class = "contentBar">
			<!-- <div style = "width : 6%; font-size : 110%; float : left; text-align : right;">
				<a href = "#" style = "text-decoration: none;">더보기 ></a>
			</div> -->
			<div style = "float : left; width : 5.7%;">
				<hr color = "#A9A9A9">
			</div>
			<div style = "float : left; width : 94.3%;">
				<hr color = "#DCDCDC">
			</div>
			
				<!-- 작성자 사진 / 작성자 / 시간 / 제목 / 내용 / 공감 / 댓글 / 사진 / 이전 1,2,3 ... , 10 다음 / 5개씩 나누기 -->
				<c:forEach items = "${postingList }" var = "posting">
				<table class = "realtimePosting">
					<tr>
						<td style = "width : 75%; height : 36px;">
							<div class = "userImgCir">
							<a href="#" style = "text-decoration: none;">
								<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "없음" class = "userImg" />
							</a>
							</div>
							<div style = "padding-left : 6%;">
							<a href="#" style = "text-decoration: none;">
								<span>${posting.userName }</span>
							</a>
								<br>
								<fmt:formatDate var = "postingDate" value = "${posting.postingDate}" pattern="MM월dd일 HH:mm"/>
								<small>${postingDate }</small>
							</div>
						</td>
						<td rowspan = "4">
							<a href="#" style = "text-decoration: none;">
								<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "없음" style = "padding-left : 5%; width : 94%; height : 170px;"/>
							</a>
						</td>
					</tr>
					<tr>
						<td style = "font-size : 110%; height : 36px;">
							포스팅 제목
						</td>
					</tr>
					<tr>
						<td>
							<div class = "postingName">
								${posting.postingContent }
							</div>
						</td>
					</tr>
					<tr>
						<td style = "height : 18px;">
							<a href = "#" style = "text-decoration : none;">공감</a> : 0
							&nbsp;&nbsp; 댓글 : 0
							<!-- <input type = "button" id = "answerButton" value="▼" /> -->
						</td>
					</tr>
				</table>
				<!-- <div id = "noneAnswer" style = "display : none;">
					댓글 하나 둘 셋
				</div> -->
				<div style = "float : left; width : 100%;">
					<hr color = "#DCDCDC">
				</div>
				</c:forEach>
	</div>
	<div class = "floorBar">	
		<div class = "togetherPeopleLeft">
			Together People<br>사람들과 함께함으로써 사람을 얻는 곳
		</div>
		<div class = "togetherPeopleRight">
			경상북도 경산시 진량읍 대구대로 299-31 TEL 010-2098-6362(대표번호, MSG)<br>
			Copyright(c) 2021 Min Sung Graphic All right Reserved.
		</div>
	</div>
</body>
</html>