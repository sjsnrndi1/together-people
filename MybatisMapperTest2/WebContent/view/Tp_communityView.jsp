<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 | 자유게시판</title>
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
	/*$( document ).ready( function() {
        $(".boardNumberMoveBtn").click(function(){
			//ajax 사용
			alert($(this).attr('value'));
			$.ajax({
				url : "page_move",
				type : "POST",
				data : "pageNumber=" + $(this).attr('value') 
			})
			
			setTimeout('autoRefresh_sample_div()', 0);
        });
  
    });
	 	<c:set var = "userName" value = "${userInfo.user_name}" />
			$.ajax({
				url: "comment_insert",
			    data: "comment=" + document.getElementById("test").innerHTML + "&boardNumber=" + ${boardInfo.boardNumber},
			    type: "POST"
			});
	

	function autoRefresh_sample_div() {
		var currentLocation = window.location;
		$("#commu_content_frame").load(currentLocation + ' #commu_content_frame');
	}*/
</script>
<style>
	.floorBar {
		position : absolute;
	}
	.commu_frame {
		width : 50%;
		height : 600px;
		margin-top : 1%;
		margin-left : 26%;
		color : #696969;
	}
	.commu_title_frame {
		width : 99.3%;
		height : 7.4%;
		margin : 2px;
		border-top : 2px solid #BC8F8F;
		border-bottom : 2px solid #BC8F8F;
	}
	.commu_content_frame {
		width : 99.3%;
		height : 85%;
		margin : 2px;
		border-bottom : 2px solid #BC8F8F;
	}
	.commu_footer_frame {
		width : 99.3%;
		height : 5%;
		margin : 2px;
	}
	.commu_title_table {
		width : 100%;
		text-align : center;
		padding-top : 10px;
		padding-bottom : 10px;
	}
	.commu_board_table {
		width : 99.3%;
		text-align : center;
		padding-top : 10px;
		margin : 2px;
		height : 9.1%;
		border-bottom : 1px solid #BC8F8F;
	}
	
	.commu_board_table a:link { color: #696969; text-decoration: none;}
	.commu_board_table a:visited { color: #696969; text-decoration: none;}
 	.commu_board_table a:hover { color: black; text-decoration: none;}
	.commu_footer_frame a:link { color: #696969; text-decoration: none;}
	.commu_footer_frame a:visited { color: #696969; text-decoration: none;}
 	.commu_footer_frame a:hover { color: black; text-decoration: none;}
 	
 	.commu_left_frame {
 		margin : 2px;
 		float : left;
 		width : 19%;
 		height : 80%;
 		text-align : right;
 	}
 	.commu_number_frame{	
 		margin : 2px;
 		float : left;
 		width : 60%;
 		height : 80%;
 		text-align : center;
 	}
 	.commu_right_frame{
 		margin : 2px;
 		float : left;
 		width : 19%;
 		height : 80%;
 		text-align : left;
 	}
 	.commu_create_frame {
 		font-size : 120%;
		width : 100%;
		height : 20px;
		color : #696969;
	}
	.commu_create_frame a:link { text-decoration : none; color : #696969;}
	.commu_create_frame a:visited { text-decoration : none;color : #696969;}
	.commu_create_frame a:active {text-decoration : none; color : #2F4F4F; }
	.commu_create_frame a:hover { text-decoration : none; color : #2F4F4F;}
	.boardSortStyle {
		font-family: 'Hanna';
		background-color : white;
		color : black;
		border : 1px solid white;
		padding : 0;
		margin:0;
		height : 80%;
		font-size : 100%;
	}
	.boardNumberMoveBtn{
		width : 8.9%;
		height : 77%;
		border-radius : 0;
		border : 1px solid white;
		border-right : 1px solid #BC8F8F;
		margin : 0;
		margin-top : 2px;
		padding : 0;
		background-color : white;
		color : black;
	}
	.commu_title_table td {
		border-right : 1px solid #BC8F8F;
	}
	.commu_title_table td a:link { text-decoration : none; color : #696969;}
	.commu_title_table td a:visited { text-decoration : none; color : #696969;}
	.commu_title_table td a:active { text-decoration : none; color : #2F4F4F;}
	.commu_title_table td a:hover { text-decoration : none; color : #2F4F4F;}
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
	
	<%! int check = 1; %>
	<c:set var = "page_check_Number" value = "1"/>
	<div class = "commu_frame" id = "commu_frame">
		<div class = "commu_create_frame">
			<c:if test = "${ssVar ne null}">
				<a href = "communityCreateBoard">작성</a>
			</c:if>
		</div>
		<div class = "commu_title_frame">
			<table class = "commu_title_table">
				<thead>
					<tr>
						<td style = "width : 5%;">순번</td><!-- ${page_check_Number} -->
						<td style = "width : 60%;"><a href = "communityView_sort?pageNumber=<%=check %>&subject=title" class = "boardSortStyle">제목</a></td>
						<td style = "width : 12%;"><a href = "communityView_sort?pageNumber=<%=check %>&subject=writer" class = "boardSortStyle">작성자</a></td>
						<td style = "width : 10%;"><a href = "communityView_sort?pageNumber=<%=check %>&subject=date" class = "boardSortStyle">작성일</a></td>
						<td style = "width : 10%;"><a href = "communityView_sort?pageNumber=<%=check %>&subject=read" class = "boardSortStyle">조회수</a></td>
					</tr>
				</thead>
			</table>
		</div>
		<div class = "commu_content_frame">
			<c:forEach items = "${boardList }" var = "board" varStatus = "status" begin = "${pageNumber }">
				<c:if test = "${board.boardSubject eq 'freedom' }">
					<c:if test = "${status.count < 11 }">					
						<table class = "commu_board_table">
							<thead>
								<tr>
									<td style = "width : 5%;">${fn:length(boardList) - status.index}</td>
									<td style = "width : 60%;"><a href = "communityContentView?boardNumber=${board.boardNumber }">${board.boardTitle}</a></td>
									<td style = "width : 12%;">${board.boardWriter}</td>
									<fmt:formatDate var = "date" value="${board.boardDate}" pattern="yyyy-MM-dd" />
									<td style = "width : 10%;">${date}</td>
									<td style = "width : 10%;">${board.boardViews }</td>
								</tr>
							</thead>
						</table>
					</c:if>
				</c:if>
			</c:forEach>
		</div>
		<div class = "commu_footer_frame">
			<div class = "commu_left_frame">
				<c:if test = "${fn:length(boardList) > 10}">
					<a href = "page_move_left_right?pageNumber=<%=check %>&move=left"> ◀ </a>
				</c:if>
			</div>
			<div class = "commu_number_frame">
				<div style = "width : 99%; height : 99%;">
					
					<c:forEach items = "${boardList }" var = "board" varStatus = "status">
						<c:choose>
							<c:when test = "${fn:length(boardList) < 11}">
								1
							</c:when>
							<c:when test = "${fn:length(boardList) / 10 > 0}">
								<c:if test = "${status.count % 10 eq 1}">
									<a href = "page_move?pageNumber=<%=check %>" class = "boardNumberMoveBtn"><%=check %></a>
									<%! check += 1; %>
									<!-- <c:set var = "page_check_Number" value = "<%=check+1 %>"/> -->
								</c:if>
							</c:when>
						</c:choose>
					</c:forEach>
				</div>
			</div>
			<div class = "commu_right_frame">
				<c:if test = "${fn:length(boardList) > 10}">
					<a href = "page_move_left_right?pageNumber=<%=check %>&move=right"> ▶ </a>
				</c:if>
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