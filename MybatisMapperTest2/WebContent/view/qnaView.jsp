<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항</title>
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
	.qnaTitle {
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
	#commandArea{
		height : 30px;
		text-align : right;
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
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<div class = "qnaTitle">
		문의사항 목록
	<hr>
	</div>
	<div style = "overflow : auto; height : 250px; text-align : center;">
		<table border = '1'>
			<tr>
				<td style = "width : 50px;">번호</td>
				<td style = "width : 100px;">제목</td>
				<td style = "width : 100px;">작성일</td>
			</tr>
		</table>
		<table border = '1'>
			<c:forEach items = "${qnaList }" var = "qna">
				<tr>
					<td style = "width : 50px;">${qna.qnaRegistNumber }</td>
					<td style = "width : 100px;">
						<a href = "qnaOpen?id=${userInfo.user_id }&number=${qna.qnaNumber }">${qna.qnaTitle }</a>
						<c:if test = "${qna.qnaComment ne 'empty' }">
							[답변완료]
						</c:if>
					</td>
					<fmt:formatDate var = "qna_date" value = "${qna.qnaDate}" pattern="yyyy-MM-dd HH:mm"/>
					<td style = "width : 100px;">${qna_date }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style = "text-align : right; border : 1px solid write; width : 38.4%; float : left;">
		<a href = "mypageView?id=${userInfo.user_id }"><input type = "button" value = "뒤로가기"/></a>
	</div>
	<div style = "text-align : center; border : 1px solid black; width : 24.5%; float : left;">

	</div>
	<div style = "text-align : left; border : 1px solid write; width : 30%; float : left;">
		<a href = "qnaRegist?id=${userInfo.user_id }"><input type = "button" value = "등록"/></a>
	</div>
</body>
</html>