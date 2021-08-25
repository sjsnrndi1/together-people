<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${userInfo.user_name} | 댓글 목록</title>
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
	function check(){
		var obj_length = document.getElementsByName("delete_board").length;
		
		if(obj_length == 0) { return false; }
		
		var count = 0;
		for (var i = 0; i < obj_length; i++) {
			if(document.getElementsByName("delete_board")[i].checked == true){
				count++;
			}
		}
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	.floorBar {
		position : absolute;
	}
	.mypage_community_frame {
		width : 50%; height : 600px; margin-left : 26%; margin-top : 0.5%; color : #696969;
	}
	.mypage_move_btn {
		width : 99.3%; height : 5%; margin : 2px; border-bottom : 1px solid #BC8F8F;
	}
	.mypage_move_btn a:link { color: #696969; text-decoration: none;}
	.mypage_move_btn a:visited { color: #696969; text-decoration: none;}
 	.mypage_move_btn a:hover { color: black; text-decoration: none;}
 	.mypage_move_btn table {
 		width : 100%; height : 100%; text-align : center;
 	}
 	.mypage_move_btn table td{
 		width : 33%;
 	}
 	.mypage_createDocBtn_joinDocBtn_frame {
 		border-bottom : 2px solid #BC8F8F; width : 99.3%; height : 4%; margin : 2px;
 	}
 	.mypage_createDocBtn_joinDocBtn {
 		display : flex; justify-content: center; align-items: center;
 	}
 	.mypage_createDocBtn_joinDocBtn a:link { color: #696969; text-decoration: none;}
	.mypage_createDocBtn_joinDocBtn a:visited { color: #696969; text-decoration: none;}
 	.mypage_createDocBtn_joinDocBtn a:hover { color: black; text-decoration: none;}
 	.delete_btn {
 		width : 100%; margin : 2px; padding-top : 2px;
 	}
 	.delete_btn a:link { color: #696969; text-decoration: none;}
	.delete_btn a:visited { color: #696969; text-decoration: none;}
 	.delete_btn a:hover { color: black; text-decoration: none;}
 	.mypage_community_title_frame {
 		width : 99.3%; margin : 2px; border-bottom : 2px solid #BC8F8F;
 	}
 	.mypage_community_title {
 		width : 99.3%; margin : 2px; padding : 2px;
 	}
 	.mypage_community_title table{
		width : 100%; text-align : center;
 	}
 	.mypage_community_content_frame {
 		border-bottom : 2px solid #BC8F8F; width : 99.3%; height : 88%; margin : 2px; overflow-y : scroll;
 	}
 	.mypage_community_content {
 		width : 99.3%; height : 99%; margin : 2px;
 	}
 	.mypage_community_content table {
 		width : 100%; height : 8.1%; text-align : center; border-bottom : 1px solid #BC8F8F;
 	}
 	.delete_btn input {
 		margin : 0; padding : 0; width : 4%; height : 50%;
 	}
 	.mypage_community_content a:link { color: #696969; text-decoration: none;}
	.mypage_community_content a:visited { color: #696969; text-decoration: none;}
 	.mypage_community_content a:hover { color: black; text-decoration: none;}
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
	<!-- 마이페이지 / 회원정보 / 즐겨찾기 / 포스팅 / 기타사항 -->
	<form action = "mypage_comment_delete" name = "mypageCommentDelete" method = "POST" onsubmit = "return check()">
	<div class = "mypage_community_frame">
		<div class = "mypage_move_btn">
			<table>
				<tr>
					<td style = "border-right : 1px solid #BC8F8F;"><a href = "myPageView">내 정보</a></td>
					<td style = "border-right : 1px solid #BC8F8F;"><a href = "mypageCommunityView">글 목록</a></td>
					<td><a href = "mypagePostingView">포스팅 목록</a></td>
				</tr>
			</table>
		</div>
		<div class = "mypage_createDocBtn_joinDocBtn_frame" style = "margin-top : 1%;">
			<div class = "mypage_createDocBtn_joinDocBtn">
				<a href = "mypageCommunityView">전체보기</a>
				<a href = "mypageJoinView" style = "margin-left : 3%;">모임</a>
				<a href = "mypageCommentView" style = "margin-left : 3%;">댓글</a>
			</div>
		</div>
		<div class = "mypage_community_title_frame">
			<div class = "mypage_community_title">
				<table>
					<tr>
						<td style = "width : 2%; border-right : 1px solid #BC8F8F;"></td>
						<td style = "width : 60%; border-right : 1px solid #BC8F8F;">댓글</td>
						<td style = "width : 10%;">작성일</td>
					</tr>
				</table>
			</div>
		</div>
		<div class = "mypage_community_content_frame">
			<div class = "mypage_community_content">
				<c:forEach items = "${boardCommentList }" var = "boardComment">
					<c:if test = "${boardComment.userId eq ssVar}">
						<table>
							<tr>
								<td style = "width : 2%;"><input type = "checkbox" name = "delete_board" value = "${boardComment.boardCommentNumber}"/></td>
								<td style = "width : 60%;"><a href = "mypageConmment_communityView?boardNumber=${boardComment.boardNumber}">${boardComment.boardComment}</a></td>
								<fmt:formatDate value = "${boardComment.boardCommentDate}" pattern = "yyyy-MM-dd" var = "boardCommentDate"/>
								<td style = "width : 10%;">${boardCommentDate}</td>
							</tr>
						</table>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class = "delete_btn">
			<input type = "submit" value = "삭제"/>
		</div>
	</div>
	</form>
		
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