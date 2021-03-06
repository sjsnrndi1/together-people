<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 | 참여게시글 작성</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupbar.css"> <!-- 전화서브메뉴바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
<!-- <link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/communityCreateBoardbar.css"> 커뮤니티 작성 화면 스타일 -->
<script type = "text/javascript" src = "http://sjsnrndi12.dothome.co.kr/js/basicAct.js"></script> <!-- 기본 행동 -->
<script>
	function check(){
		if(joinBoardRegist.join_subject.value == ""){
			alert("카테고리를 선택해주세요.");
			return false;
		} else if(joinBoardRegist.title.value == ""){
			alert("제목을 입력해주세요.");
			return false;
		} else if(joinBoardRegist.content.value == ""){
			alert("내용을 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	.join_board_frame {
		width : 50%;
		height : 648px;
		margin-top : 0.5%;
		margin-left : 26%;
		color : #696969;
	}
	.join_board_subject {
		width : 98.5%;
		margin : 2px;
		height : 5%;
		padding-left : 7px;
		padding-top : 7px;
		border-bottom : 1px solid #BC8F8F;
	}
	.join_board_title {
		width : 98.5%;
		margin : 2px;
		height : 5%;
		padding-left : 7px;
		padding-top : 7px;
		border-bottom : 1px solid #BC8F8F;
	}
	.join_board_title input {
		width : 98.5%;
		height : 65%;
		border : 1px solid white;
	}
	input:focus, textarea:focus, select:focus{
		outline : none;
	}
	.join_board_content{ /* 476 */
		width : 98.5%;
		margin : 2px;
		height : 78%;
		padding-left : 7px;
		padding-top : 7px;
		border-bottom : 1px solid #BC8F8F;
	}
	.join_board_user a:link { color: #696969; text-decoration: none;}
	.join_board_user a:visited { color: #696969; text-decoration: none;}
 	.join_board_user a:hover { color: black; text-decoration: none;}
 	.floorBar {
 		position : absolute;
 		bottom : 0;
 	}
 	.join_submit {
 		width : 98.5%;
		margin : 2px;
		height : 5%;
		padding-left : 7px;
		padding-top : 7px;
 	}
 	.join_submit input {
		width : 5%;
		height : 85%;
		margin-left : 48%;
		border-radius : 3px;
 		border : 1px solid #BC8F8F;
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
	
	<form action = "join_create_board_submit" name = "joinBoardRegist" method = "POST" onsubmit = "return check()">
		<div class = "join_board_frame">
			<div class = "join_board_subject">
				<select name = "subject" id = "join_subject" class = "join_subject">
					<option value="">카테고리</option>
					<option value="아웃도어/여행">아웃도어/여행</option>
					<option value="운동/스포츠">운동/스포츠</option>
					<option value="인문학/책/글">인문학/책/글</option>
					<option value="외국/언어">외국/언어</option>
					<option value="문화/공연/축제">문화/공연/축제</option>
					<option value="음악/악기">음악/악기</option>
					<option value="공예/만들기">공예/만들기</option>
					<option value="댄스/무용">댄스/무용</option>
					<option value="봉사활동">봉사활동</option>
					<option value="사교/인맥">사교/인맥</option>	
					<option value="차/오토바이">차/오토바이</option>
					<option value="사진/영상">사진/영상</option>
					<option value="야구관람">야구관람</option>
					<option value="게임/오락">게임/오락</option>
					<option value="요리/제조">요리/제조</option>
					<option value="반려동물">반려동물</option>
					<option value="가족/결혼">가족/결혼</option>
				</select>
			</div>
			<div class = "join_board_title">
				<input type = "text" name = "title" id = "title" class = "title" value = "" placeholder = "제목"/>
			</div>
			<div class = "join_board_content">
				<textarea rows = "33" name = "content" id = "content" class = "content" cols = "131" style = "resize : none;"></textarea>
			</div>
			<div class = "join_submit">
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