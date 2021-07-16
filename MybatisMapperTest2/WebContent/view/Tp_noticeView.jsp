<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CEO 소개</title>
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
	.aboutPhrases {
		text-align : center;
		color : #4169E1;
		padding-top : 5px;
		font-size : 130%;
	}
	.togetherPeopleIntroduce {
		width : 100%;
		height : 50%;
		background-color : #F5FFFA;
		padding-bottom : 3%;
	}
	.togetherPeoplePhrases {
		text-align : center;
		padding-top : 5px;
		font-size : 140%;
	}
	.noticeCEOTitle {
		width : 100%;
		padding-left : 25.5%;
		font-size : 130%;
		color : #4169E1;
	}
	.noticeCEOIntroduce {
		width : 35%;
		padding-left : 25.5%;
		position : relative;
		color : #696969;
	}
	.noticeCEOIntroduce img {
		width : 25%;
		height : 100%;
		display : block;
		position : absolute;
		top : 50%;
		left : 50%;
		margin-left : 48.5%;
		margin-top : -9.7%;
	}
	.floorBar {
		position : absolute;
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
	
	<div class = "togetherPeopleIntroduce">
		<br>
		<div class = "aboutPhrases">about TogetherPeople</div><br>
		<div class = "togetherPeoplePhrases">to get the people together people<br>
		사람들과 함께함으로써 사람을 얻는 곳</div>
	</div>
	
	<div class = "noticeCEOTitle">
		CEO<br>
		<span style = "font-size : 125%; color : #000000;">지금도 성장하고 있는</span><br>
		<span style = "font-size : 110%; color : #696969;">together people 인사드립니다.</span>
	</div>
	
	<div class = "noticeCEOIntroduce">
		<br>
		안녕하십니까. together people 대표 김민성입니다.<br>
		사람들과의 만남 속에서 피어나는 즐거움을 아시나요?<br>
		나의 취미, 문화생활 등 같이 즐길만한 상대가 계시나요?<br>
		그러면 잘 오셨습니다.<br><br>
		여기 together people은 여러분들을 위해 존재합니다.<br>
		같은 취미를 가진 사람들끼리 서로 바쁜 와중에 시간을 내어 만남을 도모함으로써<br>
		친밀감, 유대감이 생기며 서로가 행복한 시간을 보낼 수 있다고 생각합니다.<br>
		분명 소위말하는 '진상'이라고 불리는 사람들도 있겠지만<br>
		그런 부분들을 저희에게 제보해주시면 100%란 말은 안믿기시겠지만 최선을 다하겠습니다.<br><br>
		끝으로<br>
		사람들과 함께함으로써 좋은 인연을 만들어 나가시길 바랍니다.
		<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "CEO사진" />
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