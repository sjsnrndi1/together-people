<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<script>
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
</script>
<style>
	.userFindId {
		width : 100%;
		height : 30%;
		text-align : center;
	}
	
	.userFindIdDetail {
		text-align : center;
	}

	.loginpwView {
		text-decoration : none;
		font-size : 120%;
		color : #C0C0C0;
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
						<li><a href="userTpView">이용방법</a></li>
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
	
	<div class = "userFindId">
		<div class = "userFindIdDetail">
			<br>	
			아이디를 찾을 수 없습니다.
			<br><br>
			<a href = "loginView" class = "loginpwView">아이디찾기</a>&nbsp;
			<span style = "color : #DCDCDC;">|</span>&nbsp;
			<a href = "userRegist" class = "loginpwView">회원가입</a>
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