<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/togetherPeoplePharse.css"> <!-- 문구바 -->

<script>
	function check(){
		let id = document.getElementById("user_id").value;
		let name = document.getElementById("user_name").value;
		let phone = document.getElementById("user_phone").value;
		if(id == ""){
			alert("아이디를 입력하세요.");
			return false;
		} else if(phone == ""){
			alert("휴대전화를 입력하세요.");
			return false;
		} else if(name == ""){
			alert("이름을 입력하세요.")	;
			return false;
		}
		
		<c:forEach items = "${userList}" var = "user" varStatus = "status">
			if("${user.user_id}" == id){
				if("${user.user_name}" == name) {
					if("${user.user_phone}" == phone) {
						return true;
					}
				}
			}
			if("${status.count}" == "${fn:length(userList)}"){
				alert("가입하지 않은 아이디이거나, 잘못된 비밀번호 혹은 휴대전화입니다.");
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
	function minusCut(loc) {
		if(/[^0123456789]/g.test(loc.value)) {
			alert("숫자가 아닙니다.\n\n숫자만 입력해주십시오.");
			loc.value = "";
			loc.focus(); 
		}
		document.getElementById("signUp").disabled = 'disabled';
		document.getElementById("allAddCheck").disabled = false;
	}
</script>
<style>
	.userFindPw {
		width : 100%;
		height : 250px;
	}
	
	.userFindPwDetail {
		text-align : center;
	}
	
	.user_name, .user_phone, .user_id {
		width : 20%;
		height : 50px;
		border : 1px solid #A9A9A9;
	}
	
	input:focus {
		outline : 3px solid #F1DBC6;
		border : 1px solid #F1DBC6;
	}
	
	.userFindPw_button {
		width : 20.4%;
		height : 54px;
		font-size : 150%;
		background-color : #F1DBC6;
		color : #696969;
		border : 1px solid #C0C0C0;
	}
</style>
</head>
<body>
<form action = "find_user_password" method = "POST" onsubmit = "return check();">
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
	
	<div class = "userFindPw">
		<div class = "userFindPwDetail">
			<p><input type = "text" class = "user_id" id = "user_id" name = "user_id" value = "" placeholder = "아이디"/></p>
			<p><input type = "text" class = "user_name" id = "user_name" name = "user_name" value = "" placeholder = "이름"/></p>
			<p><input type = "tel" class = "user_phone" id = "user_phone" name = "user_phone" value = "" placeholder = "휴대전화 (-없이 입력하세요.)" onblur = "minusCut(this)"/></p>
			<p><input type = "submit" class = "userFindPw_button" value = "비밀번호 찾기"/></p>
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