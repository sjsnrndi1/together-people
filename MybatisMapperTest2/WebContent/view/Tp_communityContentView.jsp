<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardInfo.boardTitle }</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
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
	function login_before_popup() {
		alert("로그인 후 이용해주세요.");	
	}
	function login_after_popup() {
		var popupWindow = "";
		var fr = document.getElementById("popupForm");
		
		var url = "popup";
        var name = "popup test";
        var option = "width = 450, height = 800, top = 100, left = 200, location = no, resizable = no";
        
        popupWindow = window.open("", name, option);
        popupWindow.focus();
        
        fr.action = url;
        fr.method = "post";
        fr.target = name;
        fr.submit();
        fr.target = "_self";
	}
	function clip(){

		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.")
	}
	
	<c:choose>
		<c:when test = "${ssVar eq null }">
			var sym_count = 1;
		</c:when>
		<c:when test = "${ssVar ne null }">
			var sym_count = ${boardSympathy};
		</c:when>
	</c:choose>
	function sympathy_button(){
		$.ajax({
			url: "sympathy_count",
		    data: "boardNumber=" + ${boardInfo.boardNumber} + "&sym_count=" + sym_count,
		    type: "POST"
		})
		var property = document.getElementById("sympathyBtn");
		if(sym_count == 0){
			property.style.color = "white";
			sym_count = 1;
		} else {
			property.style.color = "red";
			sym_count = 0;
		}
	}
	
	var comm_count = 1;
	function comment_button(){
		var property = document.getElementById("commentBtn");
		if(comm_count == 0){
			property.style.color = "white";
			comm_count = 1;
		} else {
			property.style.color = "red";
			comm_count = 0;
		}
	}
	
	$(function (){
		$("#comment_btn").click(function (){
	  	$("#comment_frame").toggle();
	  });
	});
	
	function testtest() {
		<c:set var = "userName" value = "${userInfo.user_name}" />
		$.ajax({
			url: "comment_test",
		    data: "comment=" + document.getElementById("test").innerHTML + "&boardNumber=" + ${boardInfo.boardNumber},
		    type: "POST"
		})
		document.getElementById("test").innerHTML = "";
	}
	
	function writeDate() {
		<c:set var = "now" value = "<%=new java.util.Date()%>" />
		<fmt:formatDate var = "nowDate" value="${now}" pattern="y" />
		<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="y" />
		if (${nowDate - writeDate} > 0) {
			// 년
			document.write(${nowDate - writeDate} + "년 전");
		} else if (${nowDate - writeDate} == 0) {
			//달
			<fmt:formatDate var = "nowDate" value="${now}" pattern="M" />
			<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="M" />
			if(${nowDate - writeDate} > 0 ) {
				<fmt:formatDate var = "nowDate" value="${now}" pattern="d" />
				<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="d" />
				if(${nowDate - writeDate} < 0) {
					<fmt:formatDate var = "writeDate_year" value="${boardInfo.boardDate}" pattern="y" />
					<fmt:formatDate var = "writeDate_month" value="${boardInfo.boardDate}" pattern="M" />
					let lastDate = new Date(${writeDate_year}, ${writeDate_month}, 0);
					<fmt:formatDate var = "nowDate_day" value="${now}" pattern="d" />
					<fmt:formatDate var = "writeDate_day" value="${boardInfo.boardDate}" pattern="d" />
					let first_date = lastDate.getDate() - ${writeDate_day} + ${nowDate_day};
					document.write(first_date + "일 전"); 
				} else if (${nowDate - writeDate} >= 0) {
					<fmt:formatDate var = "nowDate" value="${now}" pattern="M" />
					<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="M" />
					document.write(${nowDate - writeDate} + "달 전");
				}
			} else if (${nowDate - writeDate} == 0) {
				//일
				<fmt:formatDate var = "nowDate" value="${now}" pattern="d" />
				<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="d" />
				if(${nowDate - writeDate} > 0) {
					document.write(${nowDate - writeDate} + "일 전");
				} else if (${nowDate - writeDate} == 0) {
					//시간
					<fmt:formatDate var = "nowDate" value="${now}" pattern="k" />
					<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="k" />
					if (${nowDate - writeDate} > 0) {
						document.write(${nowDate - writeDate} + "시간 전");					
					} else if (${nowDate - writeDate} == 0) {
						//분
						<fmt:formatDate var = "nowDate" value="${now}" pattern="mm" />
						<fmt:formatDate var = "writeDate" value="${boardInfo.boardDate}" pattern="mm" />
						if (${nowDate - writeDate} > 0) {
							document.write(${nowDate - writeDate} + "분 전");								
						} else {
							document.write("방금");
						}
					}
				}
			}
		}
	}
</script>
<style>
	.commu_board_frame {
		width : 50%;
		height : auto;
		margin-top : 1%;
		margin-left : 26%;
		color : #696969;
	}
	.commu_board_subject {
		width : 97%;
		margin : 2px;
		height : 5%;
		padding-left : 22px;
		padding-top : 15px;
		padding-bottom : 10px;
	}
	.commu_board_title {
		width : 97%;
		margin : 2px;
		height : 5%;
		padding-left : 22px;
		padding-top : 15px;
		font-size : 120%;
		padding-bottom : 15px;
	}
	.commu_board_user {
		width : 99.3%;
		margin : 2px;
		height : 40px;
		border-bottom : 1px solid #BC8F8F;
	}
	.commu_board_user table {
		width : 100%;
		margin-top : 8px;
	}
	.commu_board_user_writer {
		width : 7%;
		text-align : right;
		border-right : 1px solid #BC8F8F;
		padding-right : 10px;
	}
	.commu_board_user_time {
		width : 80%;
		text-align : left;
		padding-left : 8px;
	}
	.commu_board_user_url {
		 width : 10%;
		 text-align : center;
		 border-left : 1px solid #BC8F8F;
	}
	.commu_board_content{ /* 476 */
		width : 97%;
		margin : 2px;
		height : auto;
		padding-left : 22px;
		padding-top : 15px;
		border-bottom : 1px solid #BC8F8F;
	}
	.commu_board_sympathy_comment{
		width : 97%;
		margin : 2px;
		height : 8%;
		padding-left : 22px;
		float : left;
	}
	button {
		margin-left : 20px;
	}
	.commu_board_user a:link { color: #696969; text-decoration: none;}
	.commu_board_user a:visited { color: #696969; text-decoration: none;}
 	.commu_board_user a:hover { color: black; text-decoration: none;}
 	
 	.floorBar {
 		float : left;
 		margin-top : 10%;
 		bottom : 0;
 	}
 	.comment_frame {
		display : none;
		margin : 2px;
		float : left;
		width : 100%;
		height : auto;
		border-top : 1px solid #BC8F8F;
	}
	textarea:focus {
		outline : none;
	}
	.all_comment_frame {
		margin : 2px;
		width : 99.3%;
		padding-bottom : 2%;
		padding-top : 2%;
		border-bottom : 1px solid #BC8F8F;
	}
	.all_user_picture_name{
	 	margin : 2px;
	 	width : 99.3%;
	 	height : 25px;
	}
	.all_user_comment{
	 	margin : 2px;
	 	width : 99.3%;
	 	height : auto;
	}
	.all_user_comment_time{
	 	margin : 2px;
	 	width : 99.3%;
	 	height : 20px;
	 	font-size : 80%;
	 	margin-top : 2%;
	 }
	.child_comment_sympathy_btn{
		margin : 2px;
		width : 99.3%;
		height : 20px;
	}
	.child_comment_sympathy_btn span {
		margin-left : 88.5%;
	}
	.my_comment_frame{
		border : 1px solid #8B4513;
		margin : 2px;
		width : 99.3%;
		height : 132px;
		border-radius : 5px; 
	}
	.my_name_frame{
		margin : 2px;
		width : 99.3%;
		height : 20px;
	}
	.my_comment_write_frame{
		border : 1px solid #BC8F8F;
		border-radius : 5px;
		margin : 2px;
		width : 99.3%;
		height : 50px;
	}
	.my_comment_write_frame:focus {
		outline : none;
	}
	.writeNumber_frame{
		border-bottom : 1px solid #BC8F8F;
		margin : 2px;
		width : 99.3%;
		height : 20px;
		text-align : right;
	}
	.empty_frame{
		border-right : 1px solid #BC8F8F;
		margin : 2px;
		width : 93%;
		height : 22px;
		float : left;
	}
	.my_comment_input_frame{
		margin : 2px;
		width : 5.6%;
		height : 22px;
		float : left;
	}
	.my_comment_input_frame input{
		width : 100%;
		height : 100%;
		background-color : white;
		border : 1px solid white;
		font-weight : bold;
	}
	.login_before_my_comment {
		display : flex;
		height : 132px;
		justify-content : center;
		align-items : center;
		border : 1px sold gray;
	}
	.login_before_my_comment a:link { text-decoration : none; color : #E9967A;}
	.login_before_my_comment a:visited { text-decoration : none;color : #E9967A;}
	.login_before_my_comment a:active {text-decoration : none; color : #E9967A; }
	.login_before_my_comment a:hover { text-decoration : none; color : #E9967A;}
</style>
</head>
<body>
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
						<li><a href="userTpView">참여방법</a></li>
						<li><a href="userRegistAndLogin">회원가입 및 로그인</a></li>
					</ul>
				</li>
				<li><a href="communityView">커뮤니티</a>
					<ul>
						<li><a href="communityView">자유게시판</a></li>
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
				<c:choose>
					<c:when test = "${ssVar eq null }">
						<li><a href="loginView">로그인</a></li>
						<li><a href="userRegist">회원가입</a></li>
					</c:when>
					<c:when test = "${ssVar ne null }">
						<li><a href="myPageView">${userInfo.user_name }님</a></li>
						<li><a href="user_loginOut">로그아웃</a></li>
					</c:when>
				</c:choose>
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
	
	<div class = "commu_board_frame">
		<div class = "commu_board_subject"> <!-- 선택 분류 -->
			${boardInfo.boardSubject }
		</div>
		<div class = "commu_board_title"> <!-- 제목 -->
			${boardInfo.boardTitle }
		</div>
		<div class = "commu_board_user"> <!-- 사용자/관리자   시간   url복사  / 1 ~ 7 / 일 ~ 토 / -->
			<table>
				<tr>
					<td class = "commu_board_user_writer">${boardInfo.boardWriter}</td>
					<td class = "commu_board_user_time"><script>writeDate()</script></td>
					<td class = "commu_board_user_url"><a href="#" onclick="clip(); return false;">URL주소복사</a></td>
				</tr>
			</table>
		</div>
		<div class = "commu_board_content"> <!-- 내용 + 사진(선택사항) -->
			${boardContent }
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		</div>
		<div class = "commu_board_sympathy_comment"> <!-- 공감/댓글 -->
			<c:choose>
				<c:when test = "${ssVar eq null }">
					<button type = "button" id = "sympathy_btn" onclick = "login_before_popup()">공감<span id = "sympathyBtn">♡</span></button>
				</c:when>
				<c:when test = "${ssVar ne null }">
					<c:choose>
						<c:when test = "${boardSympathy eq 0 }">
							<button type = "button" id = "sympathy_btn" onclick = "sympathy_button()">공감<span id = "sympathyBtn" style = "color : red;">♡</span></button>
						</c:when>
						<c:when test = "${boardSympathy eq 1 }">
							<button type = "button" id = "sympathy_btn" onclick = "sympathy_button()">공감<span id = "sympathyBtn" style = "color : white;">♡</span></button>
						</c:when>
					</c:choose>
				</c:when>
			</c:choose>
			<button type = "button" id = "comment_btn" onclick = "comment_button()">댓글<span id = "commentBtn">▽</span></button>
		</div>
		
		
		<div id = "comment_frame" class = "comment_frame">
			<c:forEach items = "${boardCommentList }" var = "boardComment">
				<div class = "all_comment_frame">
					<div class = "all_user_picture_name">
						${boardComment.userName}
					</div>
					<div class = "all_user_comment">
						${boardComment.boardComment}
					</div>
					<div class = "all_user_comment_time">
						<fmt:formatDate var = "boardCommentTime" value="${boardComment.boardCommentDate }" pattern="yyyy-MM-dd HH:ss" />
						${boardCommentTime}
					</div>
					<div class = "child_comment_sympathy_btn">
						답글버튼<span>공감버튼</span>
					</div>
				</div>
 			</c:forEach>
			<div class = "my_comment_frame">
				<c:choose>
					<c:when test = "${ssVar eq null }">
						<div class = "login_before_my_comment">
							댓글을 작성하시려면&nbsp; <a href = "loginView"> 로그인 </a> &nbsp;후 이용해 주시기 바랍니다.
						</div>
					</c:when>
					<c:when test = "${ssVar ne null }">
						<div class = "my_name_frame">
							${userInfo.user_name }
						</div>
						<form action = "my_comment_input_form" name = "myCommentInputForm" method = "POST" onsubmit = "return check()">
							<div contentEditable="true" id = "test" spellcheck="false" class = "my_comment_write_frame">
							
							</div>
						<div class = "writeNumber_frame">
							타자 수
						</div>
						<div class = "empty_frame">
							
						</div>
						<div class = "my_comment_input_frame">
							<input type = "button" onclick = "testtest()" value = "등록"/>
						</div>
						</form>
					</c:when>
				</c:choose>
			</div>
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
		<form name = "popupForm" id = "popupForm" method = "POST">
			<c:choose>
				<c:when test = "${ssVar eq null }">
					<div id = "submenu-chat-app" class = "submenu-chat-app">
						<img src = "http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG" 
						onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkHoverImg.png'" 
						onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG'" onclick = "login_before_popup()" id = "chat-app" alt = "채팅"/>
					</div>
				</c:when>
				<c:when test = "${ssVar ne null }">
					<div id = "submenu-chat-app" class = "submenu-chat-app">
						<img src = "http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG" 
						onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkHoverImg.png'" 
						onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG'" onclick = "login_after_popup()" id = "chat-app" alt = "채팅"/>
					</div>
				</c:when>
			</c:choose>
		</form>
		<div class = "submenu-top-app" onclick = "location.href='firstView'">
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