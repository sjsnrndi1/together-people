<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용방법</title>
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
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
	.useTpTitle {
		width : 100%;
		padding-left : 25.5%;
		font-size : 150%;
		color : #4169E1;
	}
	.useTpContent {
		width : 47%;
		padding-left : 25.5%;
		color : #696969;
	}
	.contentFrame {
		width : 100%;
		height : 58vh;
		margin-bottom : 30vh;
	}
	.contentTitle {
		font-size : 120%;
		color : 	#FF4500;
	}
	.content {
		margin-top : 10px;
		margin-bottom : 10px;
		color : #2F4F4F;
	}
</style>
</head>
<body>
	<div class = "titleBar">
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
	
	<div class = "useTpTitle">
		<br>참여방법
	</div>
	
	<div class = "useTpContent">
		<br>
		<ol class = "contentFrame">
			<li class = "contentTitle">커뮤니티를 살펴보자!
				<ul>
					<li class = "content">자유게시판, 참여게시판, 이용후기를 살펴보세요.</li>
					<li class = "content">천천히 둘러보시면서 자신이 원하고 하고싶었던 것들에 참여해보세요!</li>
					<li class = "content" style = "margin-bottom : 2.5%;">그 어느것도 여러분을 웃으며 다정하게 반길것입니다.</li>
				</ul>
			</li>
			<li class = "contentTitle">원하는 방에 들어가기만 해보자!
				<ul>
					<li class = "content">천천히 둘러보시면서 괜찮다고 생각한 곳을 찾으셨나요?</li>
					<li class = "content">망설임없이 방에 들어가보세요! 부끄러워할 필요 없어요.</li>
					<li class = "content" style = "margin-bottom : 2.5%;">직접적인 참여 의사가 없다면 당신이 왔다간 흔적은 전혀 없으니까요.</li>
				</ul>
			</li>
			<li class = "contentTitle">참여 신청을 해보자!
				<ul>
					<li class = "content">마음에 드시는 곳을 찾으셨다면 우측 하단에 보이는 '참여신청'버튼을 눌러보세요!</li>
					<li class = "content">참! 먼저 회원가입을 하신 후 로그인한 상태에서만 '참여신청'이 가능하답니다.</li>
					<li class = "content"><a href = "userRegistAndLogin" style = "text-decoration : none; color : #DA70D6;">회원가입 및 로그인</a> 방법이 궁금하시다면 눌러주세요!</li>
					<li class = "content" style = "margin-bottom : 2.5%;">기다림없이 바로 참여가 가능하실 거에요!</li>
				</ul>
			</li>
			<li class = "contentTitle">모임을 진행해보자!
				<ul>
					<li class = "content">드디어 원하신 곳에 참여하셨군요? 이제 마지막이에요!</li>
					<li class = "content">게시된 곳에서 열린 모임들이 있으신가요? 없다면 조금만 기다려보세요. 틀림없이 생길테니까요!</li>
					<li class = "content">열린 모임이 있다면 참여를 해보세요! 게시된 방 안에 모인 회원분들끼리만 소통할 수 있는 채팅방이 따로 마련되어 있어요.</li>
					<li class = "content" style = "margin-bottom : 2.5%;">채팅을 통해 참여의사를 밝히시고 만남의 약속 날을 잡아 좋은 하루를 보내세요!</li>
				</ul>
			</li>
			<li class = "contentTitle">감사합니다.
				<ul>
					<li class = "content">잘 읽으셨나요?</li>
					<li class = "content">사람들과 취미를 공유하고 싶은데 잘 안되시는 분들! 어떻게 참여해야 하는지 모르시겠다는 분들!</li>
					<li class = "content">위에 이용방법을 읽으셨다면 모두 다 해결될 문제들이니 걱정마세요!</li>
					<li class = "content">좋은 사람들과 만나 취미를 즐기시고 행복한 하루를 보내세요!</li>
					<li class = "content">감사합니다!</li>
				</ul>
			</li>
		</ol>
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
		<div class = "submenu-top-app" onclick = "location.href='userTpView'">
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