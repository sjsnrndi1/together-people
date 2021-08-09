<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오시는 길</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
<style>
	.aboutPhrases {
		text-align : center;
		color : #4169E1;
		padding-top : 5px;
		font-size : 130%;
	}
	.togetherPeopleIntroduce {
		width : 100%;
		height : 50%;
		background-color : #F5FFFA;
		padding-bottom : 3%;
	}
	.togetherPeoplePhrases {
		text-align : center;
		padding-top : 5px;
		font-size : 140%;
	}
	.accessTitle {
		padding-left : 35%;
		font-size : 150%;
		color : #4169E1;
		margin-bottom : 1%;
	}
	#map {
		width : 25.5%;
		height : 400px;
		margin-left : 25%;
		padding-left : 24%;
	}
	#gomap {
		width : 100%;
		height : 100%;
		positiong : absolute;
	}
	.accessDetail {
		width : 100%;
		height : 100px;
		padding-left : 25.5%;
		margin-bottom : 13%;
		position : relative;
	}
	.accessDetail_mapImage {
		display : block;
		position : absolute;
		margin-left : -0.5%;
		margin-top : 1%;
	}
	.accessDetail_phoneImage {
		display : block;
		position : absolute;
		margin-left : -0.5%;
		margin-top : 4%;
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
			<a href="communityView">커뮤니티</a>
			<a href="#">고객지원</a>
		</div>					
	</div>
	
	<div class = "togetherPeopleIntroduce">
		<br>
		<div class = "aboutPhrases">about TogetherPeople</div><br>
		<div class = "togetherPeoplePhrases">to get the people together people<br>
		사람들과 함께함으로써 사람을 얻는 곳</div>
	</div>
		
	<div class = "accessTitle">
		ACCESS : 꿈과 희망이 가득 찬 together people로 초대합니다
	</div>
	
	<div id = "map">
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6f4178ab1ca7d1e961ef7624a57735dd"></script>
		<script>
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(35.895656660761254, 128.8542482715397),
				level: 3
			};
			var map = new kakao.maps.Map(container, options);
			
			//지도 스카이뷰
			//var mapTypeControl = new kakao.maps.MapTypeControl();
			//map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
			
			// 확대축소
			var zoomControl = new kakao.maps.ZoomControl();
			map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
			
			// 마커가 표시될 위치입니다 
			var markerPosition  = new kakao.maps.LatLng(35.895656660761254, 128.8542482715397);
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: markerPosition
			});
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			// 바로가기
			kakao.maps.event.addListener(marker, 'click', function() {
			      window.open("https://map.kakao.com/link/map/35.895656660761254,128.8542482715397", "지도");
			});
		</script>
	</div>
	
	<div class = "accessDetail">
		<br><br><br>
		<div style = "width : 24%; margin : 0; padding : 0; float : left;">
			<span style = "font-size : 150%;">together people</span>
			<img src = "http://sjsnrndi12.dothome.co.kr/images/mapImage.PNG" class = "accessDetail_mapImage" alt = "지도사진" />
			<div style = "display : block; position : absolute; margin-left : 2%; margin-top : 1.8%;">
				경상북도 경산시 진량읍 대구대로 299-31 (38455)
			</div>
			<img src = "http://sjsnrndi12.dothome.co.kr/images/phoneImage.PNG" class = "accessDetail_phoneImage" alt = "휴대전화사진" />
			<div style = "display : block; position : absolute; margin-left : 2%; margin-top : 4.8%;">
				010-2098-6362
			</div>
		</div>
		<div style = "width : 3%; font-size : 50%; margin : 0; padding : 0; float : left; color : #A9A9A9;">
			|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>
		</div>
		<div style = "width : 6%; margin : 0; padding : 0; float : left;">
			<br><br><br>지하철 버스 이용 <br><br><br><br><br>버스 노선번호
		</div>
		<div style = "width : 15%; margin : 0; padding : 0; float : left;">
			<br><br><br>안심역(1호선) -> 대구대 종점 건너 하차 <br><br>영남대역(2호선) -> 대구대 종점 <br><br><br>814 818-1 급행5 808 708<br><br> 840 
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
		<div class = "submenu-top-app" onclick = "location.href='noticeAccessView'">
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