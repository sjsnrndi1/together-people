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
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/togetherPeoplePharse.css"> <!-- 문구바 -->

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
</style>
</head>
<body>
<form action = "user_login" method = "POST" onsubmit="return check()">
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
		<img src = "${togetherPeopleTitle }" alt = "togetherPeople" class = "togetherPeopleIntroduceDetail"/>
		<div class = "togetherPeoplePhrases"><span>to get the people together people</span></div>
		<div class = "togetherPeoplePhrases"><span>사람들과 함께함으로써 사람을 얻는 곳</span></div>
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
</form>
</body>
</html>