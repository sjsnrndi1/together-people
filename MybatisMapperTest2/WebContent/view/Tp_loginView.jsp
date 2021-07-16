<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOGETHER PEOPLE Login</title>
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<script>
	function check(){
		let id = document.getElementById("user_id").value;
		let pw = document.getElementById("user_password").value;
		
		if(id == ""){
			alert("아이디를 입력해주세요.");
			return false;
		} else if(pw == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
		<c:forEach items = "${userList}" var = "user" varStatus = "status">
			if("${user.user_id}" == id){
				if("${user.user_password}" == pw) {
					return true;
				}
			}
			if("${status.count}" == "${fn:length(userList)}"){
				alert("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
				return false;
			}
		</c:forEach>
	}
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
	.loginBar, .userFindBar {
		width : 100%;
		height : 250px;
	}
	
	.loginDetail, .userFindBarDetail {
		text-align : center;
	}
	
	.login_id, .login_pw {
		width : 20%;
		height : 50px;
		border : 1px solid #A9A9A9;
	}
	
	input:focus {
		outline : 3px solid #F1DBC6;
		border : 1px solid #F1DBC6;
	}
	
	.login_button {
		width : 20.4%;
		height : 54px;
		font-size : 150%;
		background-color : #F1DBC6;
		color : #696969;
		border : 1px solid #C0C0C0;
	}
	
	.userFind_id, .userFind_pw, .userRegistButton {
		text-decoration: none;
		font-size : 120%;
		color : #C0C0C0;
	}
	.floorBar {
		position : absolute;
	}
</style>
</head>
<body>
<form action = "user_login" method = "POST" onsubmit="return check()">
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
						<li><a href="userTpView">이용방법</a></li>
						<li><a href="#">카테고리정보</a></li>
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
	
	<div class = "loginBar">
		<div class = "loginDetail">
			<p><input type = "text" class = "login_id" id = "user_id" name = "user_id" value = "" placeholder = "아이디"/></p>
			<p><input type = "password" class = "login_pw" id = "user_password" name = "user_password" value = "" placeholder = "비밀번호"/></p>
			<p><input type = "submit" class = "login_button" value = "로그인"/></p>
		</div>
	</div>
	
	<div class = "userFindBar">
		<div class = "userFindBarDetail">
			<a href = "findID" class = "userFind_id">아이디찾기</a>&nbsp;
			<span style = "color : #DCDCDC;">|</span>&nbsp;
			<a href = "findPassword" class = "userFind_pw">비밀번호찾기</a>&nbsp;
			<span style = "color : #DCDCDC;">|</span>&nbsp;
			<a href = "userRegist" class = "userRegistButton">회원가입</a>
		</div>
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
</form>
</body>
</html>