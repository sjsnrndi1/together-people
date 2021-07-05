<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/togetherPeoplePharse.css"> <!-- 문구바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<script>
	function check(){
		let pw = document.getElementById("user_name").value;
		let pw2 = document.getElementById("user_phone").value;
		if(pw == ""){
			alert("비밀번호를 입력하세요.");
			return false;
		} else if(pw2 == ""){
			alert("비밀번호를 한번 더 입력하세요.");
			return false;
		} else if(pw == pw2) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
	function userPwSetting() {
		let password = document.getElementById("user_password").value;
		if(password.length < 8|| password.length > 16) {
			document.getElementById("user_password_setting").innerHTML = '<font color = "red">8~13자 대 소문자, 숫자, 특수문자를 사용하세요.</font>';
        } else {
        	document.getElementById("user_password_setting").innerHTML = "";	
        }

	}
	
	function checkCapsLock(event) {
		if(event.getModifierState("CapsLock")) {
			document.getElementById("user_password_setting").innerHTML = '<font color = "red">Caps Lock이 켜져 있습니다.</font>';
		} else {
			document.getElementById("user_password_setting").innerHTML = "";
		}
	}
	
	function userPwCheck() {
		let password = document.getElementById("user_password").value;
		let passwordCheck = document.getElementById("user_passwordCheck").value;
		
		if(password == passwordCheck) {
			document.getElementById("user_password_check").innerHTML = '<font color = "blue">비밀번호가 일치합니다.</font>';
		} else {
			document.getElementById("user_password_check").innerHTML = '<font color = "red">비밀번호가 일치하지 않습니다.</font>';
		}
	}
</script>
<style>
	.userModifyPw {
		width : 100%;
		height : 250px;
	}
	
	.userModifyPwDetail {
		text-align : center;
	}
	
	#user_password, #user_passwordCheck {
		width : 20%;
		height : 50px;
		border : 1px solid #A9A9A9;
	}
	
	input:focus {
		outline : 3px solid #F1DBC6;
		border : 1px solid #F1DBC6;
	}
	
	.userFindId_button {
		width : 20.4%;
		height : 54px;
		font-size : 150%;
		background-color : #F1DBC6;
		color : #696969;
		border : 1px solid #C0C0C0;
	}
	#user_password_check, #user_password_setting {
		width : 100%;
		height : 10px;
		text-align : center;
		background-color : #F0F8FF;
		border:none;
		font-size : 100%;
	}
</style>
</head>
<body>
<form action = "modify_user_password" method = "POST" onsubmit = "return check();">
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
	
	<div class = "userModifyPw">
		<div class = "userModifyPwDetail">
			<input type = "hidden" id = "user_id" name = "user_id" value = "${user_id }"/>
			<p><input type = "password" id = "user_password"  name = "user_password" maxlength = "16" placeholder = "비밀번호" onblur = "userPwSetting()" onKeyUp = "checkCapsLock(event)"/></p>
			<div id = "user_password_setting"></div>
			<p><input type = "password" id = "user_passwordCheck" name = "user_passwordCheck" maxlength = "16" placeholder = "비밀번호 확인" onblur = "userPwCheck()" onKeyUp = "checkCapsLock(event)"/></p>
			<div id = "user_password_check"></div>
			<p><input type = "submit" class = "userFindId_button" value = "비밀번호 변경"/></p>
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