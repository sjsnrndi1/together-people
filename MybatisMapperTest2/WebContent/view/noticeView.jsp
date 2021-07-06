<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<script>
	ct = 0;
	function alarmToggle() {
		if(ct == 0) {
			ct = 1;		
			document.getElementById("alarm").style.display = 'block';
		} else if(ct == 1){
			ct = 0;
			document.getElementById("alarm").style.display = 'none';
		}
	}
</script>
<style>
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	.kategorie {
		width : 98%;
		text-align : center;
		padding : 20px;
		margin : 15px;
	}
	.notice, .board {
		display : inline-block;
		width : 25%;
		height : auto;
	}
	.mypage {
		display : inline-block;
		width : 25%;
		height : auto;
		margin-top : 20px;
	}
	.noticeTitle {
		width : 45%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	table{
		width : 580px;
		margin : auto;
	}
	#tr_title, #tr_content {
		text-align : center;
	}
	.noticeCEOTitle, .noticeAccessTitle {
		width : 100%;
		height : 100%;
		padding-left : 25.5%;
	}
	.aboutPhrases {
		text-align : center;
		color : #FF7F50;
		padding-top : 5px;
		font-size : 130%;
	}
	.togetherPeopleIntroduce {
		width : 100%;
		height : 50%;
		border : 1px solid red;
		background-color : #F5FFFA;
		padding-bottom : 3%;
	}
	.togetherPeoplePhrases {
		text-align : center;
		color : #A9A9A9;
		padding-top : 5px;
		font-size : 120%;
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
					<a href="firstView">Together People</a>
					<a href="#" class="closebtn" onclick='closeNav()'>x</a>
					<a href="noticeView">소개</a>
					<a href="boardView">공지사항</a>
					<a href="mypageView">커뮤니티</a>
				</div>
				<a href = "loginView" class = "viewDetail">로그인</a>&nbsp;&nbsp;&nbsp;						
				<a href = "userRegist" class = "viewDetail">회원가입</a>					
			</div>
			<hr align = "center" width = "50%" color = "#C0C0C0">
		</div>
	</div>
	
	<div class = "togetherPeopleIntroduce">
		<br>
		<div class = "aboutPhrases">about TogetherPeople</div><br>
		<div class = "togetherPeoplePhrases">to get the people together people<br>
		사람들과 함께함으로써 사람을 얻는 곳</div>
	</div>
	
	<div class = "noticeCEOTitle">
		CEO
		내 소개
	</div>
	
	<div class = "noticeAccessTitle">
		Access
		오시는 길 (지도)
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