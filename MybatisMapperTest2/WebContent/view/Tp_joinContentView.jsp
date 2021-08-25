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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/postingpopupbar.css"> <!-- 포스팅서브메뉴바 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
<script>
	//url복사 스크립트
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
	function showPostingPopup(hasFilter) {
		const popup = document.querySelector('#postingPopup');
	  
		if (hasFilter) {
	  		popup.classList.add('has-filter');
	  	} else {
	  		popup.classList.remove('has-filter');
	  	}
	  
	  	popup.classList.remove('hide');
	}
	function closePostingPopup() {
		const popup = document.querySelector('#postingPopup');
	  	popup.classList.add('hide');
	}
	function showKategoriPopup(hasFilter) {
		const popup = document.querySelector('#kategoriPopup');
	  
		if (hasFilter) {
	  		popup.classList.add('has-filter');
	  	} else {
	  		popup.classList.remove('has-filter');
	  	}
	  
	  	popup.classList.remove('hide');
	}
	function closeKategoriPopup() {
		const popup = document.querySelector('#kategoriPopup');
	  	popup.classList.add('hide');
	  	location.reload();
	}
	function join_accept(joinNumber){
		$.ajax({
			url: "joinUser_accept",
		    data: "joinNumber=" + joinNumber + "&joinBoardNumber=" + ${joinBoardInfo.joinBoardNumber},
		    type: "POST"
		})
		setTimeout('autoRefresh_sample_div()', 0);
	}
	function join_refuse(joinNumber){
		$.ajax({
			url: "joinUser_refuse",
		    data: "joinNumber=" + joinNumber,
		    type: "POST"
		})
		setTimeout('autoRefresh_sample_div()', 0);
	}
	function autoRefresh_sample_div() {
		$("#content_joinUser").load(location.href + ' #content_joinUser');
	}
</script>
<style>
	.join_board_frame {
		width : 50%;
		height : auto;
		margin-top : 1%;
		margin-left : 26%;
		color : #696969;
	}
	.join_board_subject {
		width : 97%;
		margin : 2px;
		height : 5%;
		padding-left : 22px;
		padding-top : 15px;
		padding-bottom : 10px;
	}
	.join_board_title {
		width : 97%;
		margin : 2px;
		height : 5%;
		padding-left : 22px;
		padding-top : 15px;
		font-size : 120%;
		padding-bottom : 15px;
	}
	.join_board_user {
		width : 99.3%;
		margin : 2px;
		height : 40px;
		border-bottom : 1px solid #BC8F8F;
	}
	.join_board_user table {
		width : 100%;
		margin-top : 8px;
	}
	.join_board_user_writer {
		width : 7%;
		text-align : right;
		border-right : 1px solid #BC8F8F;
		padding-right : 10px;
	}
	.join_board_user_time {
		width : 80%;
		text-align : left;
		padding-left : 8px;
	}
	.join_board_user_url {
		 width : 10%;
		 text-align : center;
		 border-left : 1px solid #BC8F8F;
	}
	.join_board_content{ /* 476 */
		width : 97%;
		margin : 2px;
		height : auto;
		padding-left : 22px;
		padding-top : 15px;
		border-bottom : 1px solid #BC8F8F;
	}
	button {
		margin-left : 20px;
	}
	.join_board_user a:link { color: #696969; text-decoration: none;}
	.join_board_user a:visited { color: #696969; text-decoration: none;}
 	.join_board_user a:hover { color: black; text-decoration: none;}
 	
 	.floorBar {
 		float : left;
 		bottom : 0;
 	}
 	
 	.join_board_joinApplication_frame {
 		width : 100%;
 		height : 174px;
 		margin-bottom : 1%;
 	}
 	.join_board_joinApplication {
 		width : 98%;
 		height : 20px;
 		margin : 3px;
 		padding-top : 0.5%;
 		padding-right : 1%;
 	}
 	.join_board_joinApplication a {
 		float : right;
 	}
 	.join_board_joinApplication a:link { text-decoration : none; color : #696969;}
	.join_board_joinApplication a:visited { text-decoration : none;color : #696969;}
	.join_board_joinApplication a:active {text-decoration : none; color : #2F4F4F; }
	.join_board_joinApplication a:hover { text-decoration : none; color : #2F4F4F;}
	
 	.join_board_joinUser_frame {
 		border : 1px solid #BC8F8F;
 		border-radius : 3px;
 		width : 99%;
 		height : 140px;
 		margin : 3px;
 	}
 	.join_board_joinUser_title {
		border-bottom : 1px solid #BC8F8F;
		width : 98.3%;
		height : 25px;
 		margin : 3px;
 		padding-left : 10px;
 		padding-top : 8px;
 	}
 	.join_board_joinUser_scroll {
 		width : 99%;
 		height : 95px;
 		overflow : auto;
 		margin : 3px;
 	}
 	.join_board_joinUsers {
 		float : left;
 		text-align : center;
 		width : 11.5%;
 		height : auto;
 		padding-top : 2px;
 		padding-bottom : 2px;
 		margin : 3px;
 	}
 	#kategoriPopup {
		display: flex;
		justify-content: center;
		align-items: center;
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, .7);
		z-index: 1;
	}
	#kategoriPopup.hide {
		display: none;
	}
	#kategoriPopup.has-filter {
		backdrop-filter: blur(4px);
		-webkit-backdrop-filter: blur(4px);
	}
	#kategoriPopup .content {
		padding: 20px;
		background: #fff;
		border-radius: 5px;
		width : 500px;
		height : 500px;
		box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
	}
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
			<a href="communityView">커뮤니티</a>
			<a href="#">고객지원</a>
		</div>					
	</div>
	
	<div class = "join_board_frame">
		<div class = "join_board_subject"> <!-- 선택 분류 -->
				${joinBoardInfo.joinBoardSubject}
		</div>
		<div class = "join_board_title"> <!-- 제목 -->
			${joinBoardInfo.joinBoardTitle }
		</div>
		<div class = "join_board_user"> <!-- 사용자/관리자   시간   url복사  / 1 ~ 7 / 일 ~ 토 / -->
			<table>
				<tr>
					<td class = "join_board_user_writer">모임장</td>
					<td class = "join_board_user_time">${joinBoardInfo.joinBoardWriter}</td>
					<td class = "join_board_user_url"><a href="#" onclick="clip(); return false;">URL주소복사</a></td>
				</tr>
			</table>
		</div>
		<div class = "join_board_content"> <!-- 내용 + 사진(선택사항) -->
			${joinBoardContent }
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		</div>
		<div class = "join_board_joinApplication_frame">
			<div class = "join_board_joinApplication">
			<c:if test = "${ssVar eq joinBoardInfo.joinBoardUserId}">
				<a href = "#" style = "float : left;" onclick = "showKategoriPopup(false)">참여신청목록</a>
			</c:if>
			<c:if test = "${ssVar ne null}">
				<c:choose>
					<c:when test = "${check eq 'noApplication'}">
						<a href = "#" onclick = "showPostingPopup(false)">참여신청</a>
					</c:when>
					<c:when test = "${check eq 'wait'}">
						<a href = "#" onclick = "showPostingPopup(false)">참여신청 중</a>
					</c:when>
					<c:when test = "${check eq 'participation'}">
						<a href = "#">채팅</a><!-- onclick = "showPostingPopup(false)" -->
					</c:when>
				</c:choose>
			</c:if>
			</div>
			<div class = "join_board_joinUser_frame">
				<div class = "join_board_joinUser_title">
					참여인원
				</div>
				<div class = "join_board_joinUser_scroll">
				<c:forEach items = "${JoinBoard_JoinUserList}" var = "joinUser">
					<c:if test = "${joinUser.verified eq 1}">
						<div class = "join_board_joinUsers">
							${joinUser.joinBoard_userName}
							<c:if test = "${joinUser.joinBoard_boardNumber eq joinBoardInfo.joinBoardNumber}">
								<c:if test = "${joinUser.joinBoard_userId eq joinBoardInfo.joinBoardUserId}">
									<span style = "font-size : 80%;">✨</span>
								</c:if>
							</c:if>
						</div>
					</c:if>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<form action = "joinBoard_joinUser_regist" method = "POST">
		<div id="postingPopup" class = "hide">
			<div class="content">
				<p style = "width : 100%; text-align : center;">
					<input type = "hidden" value = "${joinBoardInfo.joinBoardNumber }" name = "joinBoardNumber" />
					<button type = "button" class = "closeBtn" style = "margin : 0; float : right;" onclick="closePostingPopup()">x</button>
					<br><br><br><br>
					<c:choose>
						<c:when test = "${check eq 'noApplication'}">
							참여신청을 하시겠습니까?
							<br><br><br><br><br>
						</c:when>
						<c:when test = "${check eq 'wait'}">
							참여신청 중입니다.<br><br>
							잠시만 기다려주세요.
							<br><br><br>
						</c:when>
					</c:choose>
				</p>
				<hr>
				<c:choose>
					<c:when test = "${check eq 'noApplication'}">
						<input type = "submit" style = "margin-left : 45%; background-color : black; border : 1px solid black; color : white; border-radius : 5px;" value = "신청">
					</c:when>
					<c:when test = "${check eq 'wait'}">
						<input type = "button" onclick = "closePostingPopup()" style = "margin-left : 45%; background-color : black; border : 1px solid black; color : white; border-radius : 5px;" value = "닫기">
					</c:when>
				</c:choose>
			</div>
		</div>
	</form>
	
	<div id = "kategoriPopup" class = "hide">
		<div class = "content" id = "content">
			<button type = "button" class = "closeBtn" style = "margin : 0; float : right;" onclick="closeKategoriPopup()">x</button>
			<br><br>
			<div id = "content_frame" class = "content_frame" style = "border : 2px solid #BC8F8F; width : 100%; height : 87%; overflow-y : auto;">
				<div style = "display: flex; justify-content: center; align-items: center; margin : 2px; width : 99%; height : 8%; text-align : center;">
					<table style = "width : 99.3%; margin : 2px;">
						<tr>
							<td style = "width : 50%;">이름</td>
							<td style = "width : 50%; border-left : 1px solid #BC8F8F">참여확인</td>
						</tr>
					</table>
				</div>
				<div id = "content_joinUser" style = "margin : 2px; width : 99%; height : 92%; border-top : 1px solid #BC8F8F; text-align : center">
					<c:forEach items = "${joinUsers}" var = "joinUser">
						<div style = "display: flex; justify-content: center; align-items: center; width : 99.3%; height : 10%; margin : 2px; border-bottom : 1px solid #BC8F8F;">
							<table style = "width : 99.3%; margin : 2px;">
								<tr>
									<td style = "width : 50%;">${joinUser.joinBoard_userName}</td>
									<td style = "width : 25%; border-left : 1px solid #BC8F8F">
										<button type = "button" onclick = "join_accept(${joinUser.joinBoard_number})" style = "background-color : white; border : 1px solid white; color : black; font-weight : bold;">수락</button>
									</td>
									<td style = "width : 25%; border-left : 1px solid #BC8F8F">
										<button type = "button" onclick = "join_refuse(${joinUser.joinBoard_number})" style = "background-color : white; border : 1px solid white; color : black; font-weight : bold;">거절</button>
									</td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
			</div>
			<div style = "display: flex; justify-content: center; align-items: center; font-size : 120%; width : 100%; height : 8%;">
				Together People~			
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
		<div class = "submenu-top-app" onclick = "location.href='joinContentView'">
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
		<button onclick="closePopup()" style = "margin-left : 40%;">확인</button>
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