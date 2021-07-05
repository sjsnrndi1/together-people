<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardInfo.boardTitle }</title>
<script>
	ct = 0;
	function alarmToggle() {
		if(ct == 0) {
			ct = 1;		
			document.getElementById("alarm").style.display = 'block';
		} else if(ct == 1){
			ct = 0;
			document.getElementById("alarm").style.display = 'none';
		}
	}
</script>
<style>
	.kategorie {
		width : 98%;
		text-align : center;
		padding : 20px;
		margin : 15px;
	}
	.notice, .board {
		display : inline-block;
		width : 25%;
		height : auto;
	}
	.mypage {
		display : inline-block;
		width : 25%;
		height : auto;
		margin-top : 20px;
	}
	.boardTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	table{
		width : 580px;
		margin : auto;
	}
	#contentArea{
		width : 600px;
		height : 380px;
		margin : auto;
		border : 1px solid black;
	}
	#basicContent{
		height : 50px;
		border-bottom : 3px double black;
	}
	#detailContent{
		height : 300px;
		border-bottom : 3px double black;
	}
	#commandArea{
		height : 30px;
		text-align : right;
	}
	#userArea {
		height : auto;
		text-align : left;
		border : 1px solid black;
	}
</style>
</head>
<body>
<div style = "float : left; width : 17%; height : 150px;">
		<a href = "mainView?id=${userInfo.user_id }"><img alt = "title" src = "${togetherPeopleTitle}" style = "width : 100%; height : 150px;"></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 20%; height : 150px;">		
		<a href = "noticeView?id=${userInfo.user_id }"><img alt = "공지사항" src = "${togetherPeopleNotice }" ></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 25%; height : 150px;">		
		<a href = "boardView?id=${userInfo.user_id }&subject=all"><img alt = "게시판" src = "${togetherPeopleBoard }" ></a>
	</div>
	
	<div style = "float : left; text-align : left; width : 37.5%; height : 150px; margin-top : 13px;">	
		<c:if test = "${userInfo.user_id ne 'admin' }">	
			<a href = "mypageView?id=${userInfo.user_id }"><img alt = "마이페이지" src = "${togetherPeopleMypage }" ></a>
		</c:if>
		<c:if test = "${userInfo.user_id eq 'admin' }">
			<a href = "managementView"><img alt = "관리" src = "${togetherPeopleManagement }" ></a>
		</c:if>
	</div>
		
<div style = "float : left; width : 100%; height : 60px; text-align : right; position: relative;">
	<div style = "text-align : center; font-size : 20px;">
		<MARQUEE behavior="scroll">TOGETHER PEOPLE에 오신것을 환영합니다! 현재 코로나 때문에 힘든 상황이지만 모두 다함께 이겨내보아요! 아자아자 화이팅!</MARQUEE>
	</div>
	<div style = "margin-right : 1%;">
		<c:if test = "${userInfo.user_id ne 'admin' }">	
			<a href = "mypageView?id=${userInfo.user_id }">${userInfo.user_name }</a>님 
		</c:if>
		<c:if test = "${userInfo.user_id eq 'admin' }">	
			<a href = "managementView">관리자</a>
		</c:if>
		<img src = "${alarmClose }" alt = "알람" style = "background : no-repeat; width : 20px; hegith : 20px;" onclick = "alarmToggle()">
	</div>
	<div id = "alarm" style = "border : 2px solid black; width : 350px; height : 300px; position: relative; left:80.5%; top: 5px; display:none;">
		<div style = "text-align : left; width : 100%; height : 80%; overflow : auto;">
			<c:forEach items = "${alarms }" var = "alarm">
				<fmt:formatDate var = "alarmDate" value = "${alarm.alarmDate}" pattern="MM월dd일 HH:mm"/>
				<textarea style = "text-align : left; width : 98%; height : 60px; resize : none; " readonly>
${alarm.alarmContent }
						${alarmDate }</textarea>
			</c:forEach>
		</div>
		<hr>
		<a href = "loginView" style = "margin-right : 5%;">로그아웃</a>
	</div>
</div>
	<hr>
	<div class = "boardTitle">
		${boardInfo.boardTitle }
		<hr>
	</div>
	<section id = "contentArea">
	<section id = "basicContent">
		제목 : ${boardInfo.boardTitle } | 작성자 : ${boardInfo.boardWriter } | 참여자수 : ${boardInfo.boardJoinUserNumber }
		<c:if test = "${userInfo.user_id ne 'admin'}">
			<c:if test = "${userInfo.user_id eq boardInfo.boardUserId }">
				<a href = "boardJoinUserList?number=${boardInfo.boardNumber }&id=${userInfo.user_id}" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" id = "boardJoinUser" value = "게시글 참여신청자 목록"/></a>
			</c:if>
			<c:if test = "${userInfo.user_id ne boardInfo.boardUserId && favorite eq 'fail'}">
				<a href = "favoriteBoard?id=${userInfo.user_id }&number=${boardInfo.boardNumber }"><input type = "button" value = "즐겨찾기"/></a>
			</c:if>
			<c:if test = "${userInfo.user_id ne boardInfo.boardUserId && favorite eq 'success'}">
				<a href = "favoriteBoardCancel?id=${userInfo.user_id }&number=${boardInfo.boardNumber }"><input type = "button" value = "즐겨찾기취소"/></a>
			</c:if>
		</c:if>
	</section>
	<section id = "detailContent">
		${boardInfo.boardContent }
	</section>
	<section id = "commandArea">
		<!-- 게시글 생성자가 보는 것들 -->
		<c:if test = "${userInfo.user_id ne 'admin'}">
			<c:if test = "${userInfo.user_id eq boardInfo.boardUserId }">			
				<a href = "boardModify?number=${boardInfo.boardNumber }&id=${userInfo.user_id }"><input type = "button" value = "수정"/></a>
				<a href = "boardDelete?number=${boardInfo.boardNumber }&id=${userInfo.user_id }" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" value = "삭제"/></a>
			</c:if>
			
			<!-- 게시글 채팅참여여부 할 것인지 채팅방에 입장할 것인지 보는 것들 --><!-- 1 : 대기 중, 2 : 성공 -->
			<c:if test = "${boardJoinUserInfo.boardJoinUserCheck eq 1 }">
				<a href = "boardJoinCancel?number=${boardInfo.boardNumber }&id=${userInfo.user_id }"><input type = "button" value = "가입취소"/></a>
			</c:if>
			<c:if test = "${boardJoinUserInfo.boardJoinUserCheck eq 2 }">
				<a href = "chat?number=${boardInfo.boardNumber }&id=${userInfo.user_id }"><input type = "button" value = "채팅방 입장"/></a>	
			</c:if>
			<c:if test = "${boardJoinUserInfo.boardJoinUserCheck ne 1 && boardJoinUserInfo.boardJoinUserCheck ne 2 && userInfo.user_id ne boardInfo.boardUserId }">
				<a href = "boardJoin?number=${boardInfo.boardNumber }&id=${userInfo.user_id }"><input type = "button" value = "가입하기"/></a>	
			</c:if>
			
			<!-- 게시글 생성자가 보는 것들 -->
			<c:if test = "${userInfo.user_id eq boardInfo.boardUserId }">
				<a href = "chat?number=${boardInfo.boardNumber }&id=${userInfo.user_id }"><input type = "button" value = "채팅방 입장"/></a>
			</c:if>
		</c:if>
		<!-- 게시글 공통 -->
		<a href = "boardView?id=${userInfo.user_id }&subject=all"><input type = "button" value = "목록"/></a>			
	</section>
	<div id = "userArea" >
		참여자 명단
		<hr>
			<div style = "overflow : auto; width : 595px; height : 150px;">
			<c:if test = "${userInfo.user_id eq boardInfo.boardUserId }">
				<a href = "chatProfile?id=${userInfo.user_id }&number=${boardInfo.boardNumber }" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" value = "프로필" style = "float : right;"/></a>
			</c:if>
				게시글 방장 : ${boardInfo.boardWriter }<br>
				<c:forEach items = "${boardJoinUserList }" var = "boardJoinUser">
					<c:if test = "${boardJoinUser.boardJoinUserCheck eq 2 && boardJoinUser.boardNumber eq boardInfo.boardNumber}">
						${boardJoinUser.boardJoinUser_name }<br>
					</c:if>
				</c:forEach>
			</div>
	</div>
</section>
</body>
</html>