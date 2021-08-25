<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 | 이용후기</title>
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
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/communityViewbar.css"> <!-- 커뮤니티 전체 목록 스타일 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
<style>
	.purchaseReview_frame {
		width : 50%;
		height : 630px;
		margin-top : 1%;
		margin-left : 26%;
		color : #696969;
	}
	.purchaseReview_content_frame {
		width : 99.3%;
		height : 95%;
		margin : 2px;
		border-bottom : 2px solid #BC8F8F;
	}
	.purchaseReview_create_frame {
 		font-size : 120%;
		width : 99.3%;
		height : 20px;
		color : #696969;
		margin : 2px;
		border-bottom : 1px solid #BC8F8F;
	}
	.purchaseReview_create_frame a:link { text-decoration : none; color : #696969;}
	.purchaseReview_create_frame a:visited { text-decoration : none;color : #696969;}
	.purchaseReview_create_frame a:active {text-decoration : none; color : #2F4F4F; }
	.purchaseReview_create_frame a:hover { text-decoration : none; color : #2F4F4F;}
	.purchaseReview_content {
		width : 49.3%; height : 30%; margin : 2px; float : left; border : 1px solid #BC8F8F;
	}
	.purchaseReview_content_title {
		width : 78.3%; height : 15%; margin : 2px; float : left; border-bottom : 1px solid #BC8F8F; border-right : 1px solid #BC8F8F; text-align : center; padding-top : 7px;
	}
	.purchaseReview_content_title a:link { text-decoration : none; color : #696969;}
	.purchaseReview_content_title a:visited { text-decoration : none;color : #696969;}
	.purchaseReview_content_title a:active {text-decoration : none; color : #2F4F4F; }
	.purchaseReview_content_title a:hover { text-decoration : none; color : #2F4F4F;}
	.purchaseReview_content_userName {
		width : 19%; height : 15%; margin : 2px; float : left; border-bottom : 1px solid #BC8F8F; text-align : center; padding-top : 7px;
	}
	.purchaseReview_content_picture {
		width : 98.5%; height : 78%; margin : 2px; float : left;
	}
	.userImg {
		width : 100%; height : 98%;
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

	<div class = "purchaseReview_frame">
		<div class = "purchaseReview_create_frame">
			<c:if test = "${ssVar ne null}">
				<a href = "purchaseReviewCreate">작성</a>
			</c:if>
		</div>
		<div class = "purchaseReview_content_frame">
			<c:forEach items = "${purchaseReviewList}" var = "purchaseReview">
				<div class = "purchaseReview_content">
					<div class = "purchaseReview_content_title">
						<a href = "purchaseReview_content_view?purchaseReviewNumber=${purchaseReview.purchaseReviewNumber}">${purchaseReview.purchaseReview_title}</a>
					</div>
					<div class = "purchaseReview_content_userName">
						${purchaseReview.purchaseReview_userName}
					</div>
					<div class = "purchaseReview_content_picture">
						<a href = "purchaseReview_content_view?purchaseReviewNumber=${purchaseReview.purchaseReviewNumber}">
							<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "없음" class = "userImg" />
						</a>
					</div>
				</div>
			</c:forEach>
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