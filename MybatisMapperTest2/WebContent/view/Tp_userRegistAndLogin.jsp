<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 및 로그인 이용방법</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<script>
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
	function showPopup(hasFilter) {
		const popup = document.querySelector('#popup');
	  
	  if (hasFilter) {
	  	popup.classList.add('has-filter');
	  } else {
	  	popup.classList.remove('has-filter');
	  }
	  
	  popup.classList.remove('hide');
	}
	function closePopup() {
		const popup = document.querySelector('#popup');
	  popup.classList.add('hide');
	}
	$(function (){
		$("#chat-app").click(function (){
			$("#submenu-chat-frame").toggle();
		});
	});
</script>
<style>
	.userRigistAndLoginTitle {
		width : 100%;
		padding-left : 25.5%;
		font-size : 130%;
		color : #4169E1;
	}
	.userRigistAndLoginTitle a {
		text-decoration : none;
	}
	.userRigistAndLoginTitle a:link { text-decoration : none; color : #000000;}
	.userRigistAndLoginTitle a:visited { text-decoration : none;color : #000000;}
	.userRigistAndLoginTitle a:active {text-decoration : none; color : #2F4F4F; }
	.userRigistAndLoginTitle a:hover { text-decoration : none; color : #2F4F4F;}
	
	.userRigistAndLoginContent {
		width : 47%;
		padding-left : 25.5%;
		color : #696969;
	}
	.contentFrame {
		width : 100%;
		height : 58vh;
		margin-bottom : 10vh;
	}
	.contentTitle {
		font-size : 150%;
		color : 	#FF4500;
	}
	.content {
		margin-top : 2%;
		margin-bottom : 3%;
		color : #2F4F4F;
	}
	.userRegistIdImg {
		width : 44%;
		position : absolute;
		top : 0;
		left : 0;
	}
	.userRegistIdImgAfter {
		width : 44%;
		position : absolute;
		top : 1px;
		left : 58%;
	}
</style>
</head>
<body>
	<div id = "toptop" class = "titleBar">
		<div class="dropmenu">
			<ul>
				<li><a href="firstView">TogetherPeople</a></li>
				<li><a href="noticeView" id="current">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					<ul>
						<li><a href="noticeView">CEO</a></li>
						<li><a href="noticeAccessView">ACCESS</a></li>
					</ul>
				</li>
				<li><a href="userTpView">가이드</a>
					<ul>
						<li><a href="userTpView">참여방법</a></li>
						<li><a href="userRegistAndLogin">회원가입 및 로그인</a></li>
					</ul>
				</li>
				<li><a href="#">커뮤니티</a>
					<ul>
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">참여게시판</a></li>
						<li><a href="#">이용후기</a></li>
					</ul>
				</li>
				<li><a href="#">고객지원</a>
					<ul>
						<li><a href="#">도움말</a></li>
						<li><a href="#">1:1문의</a></li>
						<li><a href="#">신고</a></li>
					</ul>
				</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><a href="loginView">로그인</a></li>
				<li><a href="userRegist">회원가입</a></li>
				<li><a href ="#" class="openmenu" onclick='openNav()' style = "font-size : 100%;">전체메뉴</a></li>
			</ul>
		</div>
		
		<div id="mysidenav" class="sidenav">
			<a href="firstView">Together People</a>
			<a href="#" class="closebtn" onclick='closeNav()'>x</a>
			<a href="noticeView">소개</a>
			<a href="userTpView">가이드</a>
			<a href="#">커뮤니티</a>
			<a href="#">고객지원</a>
		</div>					
	</div>
	
	<div class = "userRigistAndLoginTitle">
		<br><a href = "#userRegistBtn">회원가입</a> / <a href = "#userLoginBtn">로그인</a> / <a href = "#userFindIdBtn">아이디 찾기</a> / <a href = "#userFindPwBtn">비밀번호 찾기</a>
	</div>
	
	<div id = "userRegistBtn" class = "userRigistAndLoginContent">
		<br>
		<ul class = "contentFrame">
			<li class = "contentTitle">회원가입 방법!
				<ol>
					<li class = "content">
						우측 상단의 '회원가입' 버튼을 클릭하세요<br>
						<img src = "http://sjsnrndi12.dothome.co.kr/images/userRegistImg.PNG" style = "width : 100%;" alt = "없음"/>
					</li>
					<li class = "content" style = "margin-bottom : 11%;">
						빈칸에 알맞은 내용을 작성해 주세요<br>
						<div style = "position : relative; text-align : center;">
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userRegistIdImg.PNG" alt = "없음" class = "userRegistIdImg" />
							<span style = "padding-left : 4%;">-></span>
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userRegistIdImgAfter.PNG" alt = "없음" class = "userRegistIdImgAfter" />
						</div>
					</li>
					<li class = "content">
						'회원가입'버튼을 누르세요
					</li>
				</ol>
			</li>
		</ul>
	</div>
	
	<div id = "userLoginBtn" class = "userRigistAndLoginContent">
		<br>
		<ul class = "contentFrame">
			<li class = "contentTitle">로그인 방법!
				<ol>
					<li class = "content">
						우측 상단의 '로그인' 버튼을 클릭하세요<br>
						<img src = "http://sjsnrndi12.dothome.co.kr/images/userLoginImg.png" style = "width : 100%;" alt = "없음"/>
					</li>
					<li class = "content" style = "margin-bottom : 16%;">
						아이디와 비밀번호를 입력해 주세요<br>
						<div style = "position : relative; text-align : center;">
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userLoginInputImg.PNG" alt = "없음" class = "userRegistIdImg" />
							<span style = "padding-left : 4%;">-></span>
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userLoginInputImgAfter.PNG" alt = "없음" class = "userRegistIdImgAfter" />
						</div>
					</li>
					<li class = "content">
						'로그인'버튼을 누르세요
					</li>
				</ol>
			</li>
		</ul>
	</div>
	
	<div id = "userFindIdBtn" class = "userRigistAndLoginContent">
		<br>
		<ul class = "contentFrame">
			<li class = "contentTitle">아이디 찾는 방법!
				<ol>
					<li class = "content">
						우측 상단의 '로그인' 버튼을 클릭하세요<br>
						<img src = "http://sjsnrndi12.dothome.co.kr/images/userLoginImg.png" style = "width : 100%;" alt = "없음"/>
					</li>
					<li class = "content">
						비밀번호 입력칸 밑에 위치한 '아이디 찾기' or '비밀번호 찾기' 버튼을 클릭하세요<br>
						<div style = "max-height : 50px; overflow: hidden;">
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userFindIdImg.png" alt = "없음" style = "max-height: initial; margin-top: 0%;"/>
						</div>
					</li>
					<li class = "content">
						이름과 휴대전화를 입력해 주세요
					</li>
					<li class = "content">
						'아이디 찾기'버튼을 누르세요
					</li>
				</ol>
			</li>
		</ul>
	</div>
	
	<div id = "userFindPwBtn" class = "userRigistAndLoginContent">
		<br>
		<ul class = "contentFrame">
			<li class = "contentTitle">비밀번호 찾는 방법!
				<ol>
					<li class = "content">
						우측 상단의 '로그인' 버튼을 클릭하세요<br>
						<img src = "http://sjsnrndi12.dothome.co.kr/images/userLoginImg.png" style = "width : 100%;" alt = "없음"/>
					</li>
					<li class = "content">
						비밀번호 입력칸 밑에 위치한 '아이디 찾기' or '비밀번호 찾기' 버튼을 클릭하세요<br>
						<div style = "max-height : 50px; overflow: hidden;">
							<img src = "http://sjsnrndi12.dothome.co.kr/images/userFindPwImg.png" alt = "없음" style = "max-height: initial; margin-top: 0%;"/>
						</div>
					</li>
					<li class = "content">
						아이디와 이름, 휴대전화를 입력해 주세요
					</li>
					<li class = "content">
						'비밀번호 찾기'버튼을 누르세요
					</li>
				</ol>
			</li>
		</ul>
	</div>
	
	<div class = "submenu-frame">
		<div class = "submenu-phone-app">
			<a href = "#" onclick = "showPopup(false)"><img src = "http://sjsnrndi12.dothome.co.kr/images/phoneImg.PNG" 
			onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/phoneHoverImg.png'" 
			onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/phoneImg.PNG'" alt = "전화"/></a>
		</div>
		<div class = "submenu-map-app">
			<a href = "noticeAccessView"><img src = "http://sjsnrndi12.dothome.co.kr/images/gomapImg.PNG" 
			onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/gomapHoverImg.png'" 
			onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/gomapImg.PNG'" alt = "오시는 길"/></a>
		</div>
		<div id = "submenu-chat-app" class = "submenu-chat-app">
			<img src = "http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG" 
			onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkHoverImg.png'" 
			onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG'" id = "chat-app" alt = "채팅"/>
		</div>
		<div class = "submenu-top-app" onclick = "location.href='userRegistAndLogin'">
			∧<br>top
		</div>
	</div>
	
	<div id="popup" class="hide">
		<div class="content">
			<p>
				<span class = "content-title">전화번호</span><br><br>
			</p>
			<p class = "content-content">
				<span class = "content-tp">"together people"입니다.</span><br><br>
				<span class = "content-phone">010-2098-6362</span><br><br>
				<span class = "content-ct">전화연결은 휴대폰으로 가능합니다</span><br><br>
			</p>
		<hr>
		<br>
		<button onclick="closePopup()">확인</button>
		</div>
	</div>
	
	<div id = "submenu-chat-frame" class = "submenu-chat-frame">
		<div class = "submenu-chat-title" style = "border : 1px solid red; width : 100%; height : 8%; font-size : 120%;">
			Together people 톡
		</div>
		<div class = "submenu-chat-content-frame" style = "border : 1px solid red; width : 100%; height : 92%;">
			<div class = "submenu-chat-content-content" style = "border : 1px solid red; width : 100%; height : 80%;">
				내용
			</div>
			<div class = "submenu-chat-content-input" style = "border : 1px solid red; width : 100%; height : 20%; color : #808080;">
				<div style = "float : left; border : 1px solid red; width : 18%;">
					<input type = "text" value = "사진등록" style = "width : 92%;"/>
				</div>
				<div style = "float : left; border : 1px solid red; width : 60%; height : 95%;">
					메세지 입력 칸
				</div>
				<div style = "float : left; border : 1px solid red; width : 18%;">
					<input type ="text" value = "입력" style = "width : 92%;"/>
				</div>
			</div>
		</div>
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