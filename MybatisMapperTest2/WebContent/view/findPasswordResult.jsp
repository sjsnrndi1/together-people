<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/togetherPeoplePharse.css"> <!-- 문구바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<script>
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
</script>
<style>
	.userPwModify {
		width : 100%;
		height : 30%;
		text-align : center;
	}
	
	.userPwModifyDetail {
		text-align : center;
	}

	.loginView {
		text-decoration : none;
		font-size : 120%;
		color : #C0C0C0;
	}
</style>
</head>
<body>
<div class = "titleBar">
		<div class = "fixedTitleBar">
			<div class = "titleBarDetail">
				<a href = "firstView" class = "viewDetail">TogetherPeople</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href = "noticeView" class = "viewDetail">소개</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href = "boardView" class = "viewDetail">공지사항</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href = "mypageView"class = "viewDetail">커뮤니티</a>
				<span class="openmenu" onclick='openNav()' style = "font-family:'Hanna';font-size:100%;color:white;padding-left:24%;"><i class="fa fa-angle-double-left fa-5" aria-hidden="true"></i>전체메뉴</span>
				&nbsp;&nbsp;&nbsp;<div id="mysidenav" class="sidenav">
					<a href="#">Together People</a>
					<a href="#" class="closebtn" onclick='closeNav()'>x</a>
					<a href="#">소개</a>
					<a href="#">공지사항</a>
					<a href="#">커뮤니티</a>
				</div>
				
				<a href = "loginView" class = "viewDetail">로그인</a>&nbsp;&nbsp;&nbsp;
				<a href = "userRegist" class = "viewDetail">회원가입</a>
			</div>
			<hr align = "center" width = "50%" color = "#C0C0C0">
		</div>
	</div>
	
	<div class = "togetherPeopleIntroduce">
		<img src = "${togetherPeopleTitle }" alt = "togetherPeople" class = "togetherPeopleIntroduceDetail"/>
		<div class = "togetherPeoplePhrases"><span>to get the people together people</span></div>
		<div class = "togetherPeoplePhrases"><span>사람들과 함께함으로써 사람을 얻는 곳</span></div>
	</div>
	
	<div class = "userPwModify">
		<div class = "userPwModifyDetail">
			<br>	
			${user_id }님의 비밀번호가 변경되었습니다.
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