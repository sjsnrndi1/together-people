<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 | 이용후기 작성</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/communityCreateBoardbar.css"> <!-- 커뮤니티 작성 화면 스타일 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
<script>
	function check(){
		if(boardRegist.commu_subject.value == ""){
			alert("카테고리를 선택해주세요.");
			return false;
		} else if(boardRegist.title.value == ""){
			alert("제목을 입력해주세요.");
			return false;
		} else if(boardRegist.content.value == ""){
			alert("내용을 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	.commu_board_file{
		width : 98.5%;
		margin : 2px;
		height : 5%;
		padding-left : 7px;
		padding-top : 7px;
		border-bottom : 1px solid #BC8F8F;
	}
	.commu_board_file input {
		margin-left : 0;
	}
	.purchaseReview_board_content{ /* 476 */
		width : 98.5%;
		margin : 2px;
		height : 72%;
		padding-left : 7px;
		padding-top : 7px;
		border-bottom : 1px solid #BC8F8F;
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
	
	<form action = "purchaseReview_create_submit" name = "purchaseReviewCreate" method = "POST" onsubmit = "return check()">
		<div class = "commu_board_frame">
			<div class = "commu_board_subject">
				<select name = "subject" id = "commu_subject" class = "commu_subject">
					<option value="freedom">이용후기</option>
				</select>
			</div>
			<div class = "commu_board_title">
				<input type = "text" name = "title" id = "title" class = "title" value = "" placeholder = "제목"/>
			</div>
			<div class = "commu_board_file">
				<input type = "file" value = "이미지 등록"  id = "ct_pt" name = "ct_pt" accept = "image/*"/>
			</div>
			<div class = "purchaseReview_board_content">
				<textarea rows = "30" name = "content" id = "content" class = "content" cols = "131" style = "resize : none;"></textarea>
			</div>
			<div class = "commu_submit">
				<input type = "submit" value = "작성" />
			</div>
		</div>
	</form>
	
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