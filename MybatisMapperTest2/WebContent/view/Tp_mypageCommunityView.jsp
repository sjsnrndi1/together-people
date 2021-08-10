<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${userInfo.user_name} | 글 목록</title>
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
	function minusCut(loc) {
		if(/[^0123456789]/g.test(loc.value)) {
			alert("숫자가 아닙니다.\n\n숫자만 입력해주십시오.");
			loc.value = "";
			loc.focus(); 
		}
		document.getElementById("signUp").disabled = 'disabled';
		document.getElementById("allAddCheck").disabled = false;
	}
	function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }       
	function check(){
		if(mypageInformationUpdate.user_name.value == "") {
			if(mypageInformationUpdate.sample4_postcode.value == ""){
				if(mypageInformationUpdate.sample4_roadAddress.value == ""){
					if(mypageInformationUpdate.sample4_jibunAddress.value == ""){
						if(mypageInformationUpdate.sample4_detailAddress.value == ""){
							if(mypageInformationUpdate.user_phone.value == ""){
								if(mypageInformationUpdate.user_email.value == ""){
									if(mypageInformationUpdate.user_information.value == "") {
										alert("아무거나 하나라도 입력해주세요.");
										return false;
									} else { return true;}
								} else { return true;}
							} else { return true;}
						} else { return true;}
					} else { return true;}
				} else { return true;}
			} else { return true;}
		} else {
			return true;
		}
	}
	function delete_board(){
		var obj_length = document.getElementsByName("delete_board").length;
		var checkList = new Array();
		
		var count = 0;
		for (var i = 0; i < obj_length; i++) {
			if(document.getElementsByName("delete_board")[i].checked == true){
				checkList[count] = document.getElementsByName("delete_board")[i].value;
				alert(checkList[count]);
				count++;
			}
		}
		
		$.ajax({
			url: "mypage_delete_board",
		    data: "subject" + checkList,	
		    type: "POST"
		});
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
	<!-- 마이페이지 / 회원정보 / 즐겨찾기 / 포스팅 / 기타사항 -->
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
				&nbsp;&nbsp;<a href = "mypageCommunityView">내 글 보기</a>
				<a href = "#" style = "margin-left : 6%;">참여한 모임</a>
			</div>
		</div>
		<div class = "mypage_community_title_frame">
			<div class = "mypage_community_title">
				<table>
					<tr>
						<td style = "width : 2%; border-right : 1px solid #BC8F8F;"></td>
						<td style = "width : 10%; border-right : 1px solid #BC8F8F;">카테고리</td>
						<td style = "width : 40%; border-right : 1px solid #BC8F8F;">제목</td>
						<td style = "width : 10%; border-right : 1px solid #BC8F8F;">작성일</td>
						<td style = "width : 10%;">조회수/참여자수</td>
					</tr>
				</table>
			</div>
		</div>		
		<div class = "mypage_community_content_frame">
			<div class = "mypage_community_content">
				<c:forEach items = "${myBoardList }" var = "myboard">
					<table>
						<tr>
							<td style = "width : 2%;"><input type = "checkbox" name = "delete_board" value = "${myboard.boardSubject}/${myboard.boardNumber}"/></td>
							<td style = "width : 10%;">
								<c:if test = "${myboard.boardSubject eq 'freedom'}">자유</c:if>
								<c:if test = "${myboard.boardSubject ne 'freedom'}">${myboard.boardSubject}</c:if>
							</td>
							<td style = "width : 40%;">${myboard.boardTitle}</td>
							<fmt:formatDate value = "${myboard.boardDate}" pattern = "yyyy-MM-dd" var = "boardDate"/>
							<td style = "width : 10%;">${boardDate}</td>
							<td style = "width : 10%;">
								${myboard.boardViews}
								<c:if test = "${myboard.boardSubject eq 'freedom'}">회</c:if>
								<c:if test = "${myboard.boardSubject ne 'freedom'}">명</c:if>
							</td>
						</tr>
					</table>
				</c:forEach>
			</div>
		</div>
		<div class = "delete_btn">
			<button type = "button" onclick = "delete_board()" style = "margin : 0; padding : 0; background-color : white; color : black; border : 1px solid black; width : 4%; height : 50%;">삭제</button>
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