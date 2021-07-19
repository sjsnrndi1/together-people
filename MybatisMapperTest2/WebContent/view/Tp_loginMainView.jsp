<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOGETHER PEOPLE</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<link rel = "stylesheet" href = "http://121.181.36.139:8020/filezilaFolder/style/postingpopupbar.css"> <!-- 포스팅서브메뉴바 -->
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
	$(function (){
		$("#chat-app").click(function (){
			$("#submenu-chat-frame").toggle();
		});
	});
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
		if(userPostingRegist.ct_ti.value == ""){
			alert("제목을 입력해주세요.");
			userPostingRegist.ct_ti.focus();
			return false;
		} else if(userPostingRegist.ct_ct.value == ""){
			alert("내용제목을 입력해주세요.");
			userPostingRegist.ct_ct.focus();
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	.contentBar {
		width : 50%;
		height : 600px;
		background-color : #FFFFFF;
		margin-left : 25%;
		color : #696969;
		font-family: 'Hanna';
		overflow : auto;
		-ms-overflow-style: none;
		scrollbar-width: none;
		padding-bottom : 1%;
	}
	.contentBar::-webkit-scrollbar {
		display: none;
	}
	.contentBar a:link { color : #696969; }
	.contentBar a:visited { color : #696969; }
	.contentBar a:hover { color : #696969; }
	.contentBar a:black { color : #696969; }
	
	.realtimePosting {
		border : 1px;
		width : 99%;
		height : 190px;
		font-family: 'Hanna';
	}
	
	.userImgCir {
		width : 35px;
		height : 35px;
		border-radius : 70%;
		overflow : hidden;
		background: #BDBDBD;
		float : left;
	}
	
	.userImg {
		width : 100%;
		height : 100%;
		object-fit: cover;
	}
	
	.postingName {
		overflow: hidden;
    	text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 3; /* 라인수 */
		-webkit-box-orient: vertical;
		word-wrap:break-word;
		line-height: 1.2em;
  		height: 3.6em; /* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
	}
	.postingView {
		font-size : 140%;
		width : 49.2%;
		float : left;
		height : auto;
		margin-left : 25%;
		padding-top : 1%;
		color : #696969;
	}
	.postingView a {
		float : right;
		text-decoration : none;
	}
	.postingView a:link { text-decoration : none; color : #696969;}
	.postingView a:visited { text-decoration : none;color : #696969;}
	.postingView a:active {text-decoration : none; color : #2F4F4F; }
	.postingView a:hover { text-decoration : none; color : #2F4F4F;}
	.floorBar {
		position : absolute;
	}
</style>
</head>
<body>
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
				<li><a href="loginView">${userInfo.user_name }님</a></li>
				<li><a href="userRegist">로그아웃</a></li>
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
	
	<div class = "postingView">
		포스팅<small style = "font-size : 70%;">(당신의 일상을 모두와 자유롭게 공유하세요.)</small>
		<a href = "#" onclick = "showPostingPopup(false)">작성</a>
	</div>
	
	<form action = "user_posting_regist" name = "userPostingRegist" method = "POST" onsubmit = "return check()">
		<div id="postingPopup" class="hide">
			<div class="content">
				<p style = "width : 100%;">
					<input type = "hidden" value = "${userInfo.user_id }" id = "user_posting_id" name = "user_posting_id" />
					<input type = "text" maxlength = "20" value = "" placeholder = "포스팅 제목" class = "content-title" id = "ct_ti" name = "ct_ti">
					<button type = "button" class = "closeBtn" style = "margin : 0; float : right;" onclick="closePostingPopup()">x</button>
					<input type = "file" value = "이미지 등록"  id = "ct_pt" name = "ct_pt" accept = "image/*" style = "float : right; margin-right : 2%; width : 37%;"/>
				</p>
				<textarea rows = "6" cols = "68" class = "content-content" id = "ct_ct" name = "ct_ct"></textarea>
			<hr>
			<input type = "submit" value = "등록">
			</div>
		</div>
	</form>
	
<!-- 실시간 포스팅 / 공지사항 / 이용후기 / 진행중인 모임 -->
	<div class = "contentBar">
			<!-- <div style = "width : 6%; font-size : 110%; float : left; text-align : right;">
				<a href = "#" style = "text-decoration: none;">더보기 ></a>
			</div> -->
			<div style = "float : left; width : 5.7%;">
				<hr color = "#A9A9A9">
			</div>
			<div style = "float : left; width : 94.3%;">
				<hr color = "#DCDCDC">
			</div>
			
				<!-- 작성자 사진 / 작성자 / 시간 / 제목 / 내용 / 공감 / 댓글 / 사진 / 이전 1,2,3 ... , 10 다음 / 5개씩 나누기 -->
				<c:forEach items = "${postingList }" var = "posting">
				<table class = "realtimePosting">
					<tr>
						<td style = "width : 75%; height : 36px;">
							<div class = "userImgCir">
							<a href="#" style = "text-decoration: none;">
								<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "없음" class = "userImg" />
							</a>
							</div>
							<div style = "padding-left : 6%;">
							<a href="#" style = "text-decoration: none;">
								<span>${posting.userName }</span>
							</a>
								<br>
								<fmt:formatDate var = "postingDate" value = "${posting.postingDate}" pattern="MM월dd일 HH:mm"/>
								<small>${postingDate }</small>
							</div>
						</td>
						<td rowspan = "4">
							<a href="#" style = "text-decoration: none;">
								<img src = "http://sjsnrndi12.dothome.co.kr/images/siba.png" alt = "없음" style = "padding-left : 5%; width : 94%; height : 170px;"/>
							</a>
						</td>
					</tr>
					<tr>
						<td style = "font-size : 110%; height : 36px;">
							포스팅 제목
						</td>
					</tr>
					<tr>
						<td>
							<div class = "postingName">
								${posting.postingContent }
							</div>
						</td>
					</tr>
					<tr>
						<td style = "height : 18px;">
							<a href = "#" style = "text-decoration : none;">공감</a> : 0
							&nbsp;&nbsp; 댓글 : 0
							<!-- <input type = "button" id = "answerButton" value="▼" /> -->
						</td>
					</tr>
				</table>
				<!-- <div id = "noneAnswer" style = "display : none;">
					댓글 하나 둘 셋
				</div> -->
				<div style = "float : left; width : 100%;">
					<hr color = "#DCDCDC">
				</div>
				</c:forEach>
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
		<div id = "submenu-chat-app" class = "submenu-chat-app">
			<img src = "http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG" 
			onmouseover = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkHoverImg.png'" 
			onmouseout = "this.src='http://sjsnrndi12.dothome.co.kr/images/talktalkImg.PNG'" id = "chat-app" alt = "채팅"/>
		</div>
		<div class = "submenu-top-app" onclick = "location.href='loginMainView'">
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
	
	<div id = "submenu-chat-frame" class = "submenu-chat-frame">
		<div class = "submenu-chat-title" style = "border : 1px solid red; width : 100%; height : 8%; font-size : 120%;">
			Together people 톡
		</div>
		<div class = "submenu-chat-content-frame" style = "border : 1px solid red; width : 100%; height : 92%;">
			<div class = "submenu-chat-content-content" style = "border : 1px solid red; width : 100%; height : 80%;">
				내용
			</div>
			<div class = "submenu-chat-content-input" style = "border : 1px solid red; width : 100%; height : 20%; color : #808080;">
				<div style = "float : left; border : 1px solid red; width : 18%;">
					<input type = "text" value = "사진등록" style = "width : 92%;"/>
				</div>
				<div style = "float : left; border : 1px solid red; width : 60%; height : 95%;">
					메세지 입력 칸
				</div>
				<div style = "float : left; border : 1px solid red; width : 18%;">
					<input type ="text" value = "입력" style = "width : 92%;"/>
				</div>
			</div>
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