<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOGETHER PEOPLE Login</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
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
	<input type = "hidden" value = "${ssVar}" id = "user_id_session" name = "user_id_session"/>
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
				<li><a href="communityView">커뮤니티</a>
					<ul>
						<li><a href="communityView">자유게시판</a></li>
						<li><a href="joinView">참여게시판</a></li>
						<li><a href="purchaseReview">이용후기</a></li>
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
			<a href="communityView">커뮤니티</a>
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