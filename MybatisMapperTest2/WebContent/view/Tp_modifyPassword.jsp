<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
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
	
	.user_password, .user_passwordCheck {
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
	.user_password_check, .user_password_setting {
		width : 100%;
		height : 10px;
		text-align : center;
		background-color : #F0F8FF;
		border:none;
		font-size : 100%;
	}
	.floorBar {
		position : absolute;
	}
</style>
</head>
<body>
<form action = "modify_user_password" method = "POST" onsubmit = "return check();">
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
	
	<div class = "userModifyPw">
		<div class = "userModifyPwDetail">
			<input type = "hidden" id = "user_id" class = "user_id" name = "user_id" value = "${user_id }"/>
			<p><input type = "password" id = "user_password" class = "user_password" name = "user_password" maxlength = "16" placeholder = "비밀번호" onblur = "userPwSetting()" onKeyUp = "checkCapsLock(event)"/></p>
			<div id = "user_password_setting" class = "user_password_setting"></div>
			<p><input type = "password" id = "user_passwordCheck" class = "user_passwordCheck" name = "user_passwordCheck" maxlength = "16" placeholder = "비밀번호 확인" onblur = "userPwCheck()" onKeyUp = "checkCapsLock(event)"/></p>
			<div id = "user_password_check" class = "user_password_check"></div>
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