<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script>
	function oneCheckbox(a){
	    var obj = document.getElementsByName("check");
	    for(var i = 0; i < obj.length; i++){
	        if(obj[i] != a){
	            obj[i].checked = false;
	        }
	    }
	}
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
	.logout {
		text-align : center;
		padding-left : 90%;
	}
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
	.noticeTitle {
		width : 45%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	table{
		width : 580px;
		margin : auto;
	}
	#tr_title, #tr_content {
		text-align : center;
	}
	#boardRegist {
		text-align : center;
	}
	.boardList {
		text-align : center;
	}
</style>
</head>
<body>
<form action = "adminBoardDelete">
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
	<div class = "noticeTitle">
		게시판 목록<br><input type = "button" value = "새로고침" onclick = "location.reload()"/>
	</div>
	<hr>
	<table border = '1' class = "boardList">
		<tr>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=all">전체</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=study">스터디</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=exercise">운동</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=game">게임</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=tour">여행</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=meal">식사</a></td>
			<td><a href = "boardView?id=${userInfo.user_id }&subject=etc">기타</a></td>
		</tr>
	</table>
	<div style = "overflow : auto; height : 210px; text-align : center;">
		<table border = '1'>
			<tr id = "tr_title">
				<c:if test = "${userInfo.user_id eq 'admin' }">
					<td></td>
				</c:if>
				<td class = "td_num">번호</td>
				<td class = "td_boardSubject">카테고리</td>
				<td class = "td_writer">작성자</td>
				<td class = "td_subject">제목</td>
				<td class = "td_regDate">작성일</td>
				<td class = "td_readcount">참여자수</td>
			</tr>
				<c:forEach items = "${boardList }" var = "board">
					<tr id = "tr_content">
						<c:if test = "${userInfo.user_id eq 'admin' }">
							<td><input type = "checkbox" id = "check" name = "check" value = "${board.boardNumber }" onclick = "oneCheckbox(this)"/></td>
						</c:if>
						<td>${board.boardRegistNumber }</td>
						<td>${board.boardSubject }</td>	
						<td>${board.boardWriter }</td>
						<td><a href = "boardOpen?number=${board.boardNumber }&id=${userInfo.user_id}">${board.boardTitle }</a></td>
						<fmt:formatDate var = "board_date" value = "${board.boardDate}" pattern="yyyy-MM-dd HH:mm"/>
						<td>${board_date }</td>
						<td>${board.boardJoinUserNumber }</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<div style = "text-align : center;">
		<input type = "text" id = "searchText" name = "searchText" value = "" style = "width : 250px;"/><input type = "submit" value = "검색"/>
	</div>
	<hr>
	<div style = "text-align : center;">
		<c:if test = "${userInfo.user_id eq 'admin' }">
			<input type = "submit"  id = "boardRegist" name = "boardRegist" value = "삭제"/>
		</c:if>
		<c:if test = "${userInfo.user_id ne 'admin' }">
			<a href = "boardRegist?id=${userInfo.user_id }"><input type = "button"  id = "boardRegist" name = "boardRegist" value = "등록"/></a>
		</c:if>
	</div>
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "hidden" id = "subject" name = "subject" value = "${subject }"/>
	<input type = "hidden" id = "check" name = "check" value = "empty"/>
</form>
</body>
</html>