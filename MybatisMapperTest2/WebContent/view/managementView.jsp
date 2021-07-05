<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리</title>
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
	.managementTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	.userTable{
		width : 723px;
		height : 100px;
		margin : auto;
	}
	#commandArea{
		height : 30px;
		text-align : right;
	}
	.td_title{
		width : 100px;
		text-align : center;
	}
	.tr_title{
		height : 30px;
		text-align : center;
	}
	.td_writer, .td_boardtitle, .td_date, .td_favorite{
		text-align : center;
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
	<div class = "managementTitle">
		관리
	</div>
		<hr>
<form action = "adminUserExile">
	<input type = "hidden" id = "check" name = "check" value = "empty"/>
	<fieldset style = "width : 723px; height : 195px; margin-left : 30%;">
		<legend style = "text-align = center;">[회원 관리]</legend>
			<table border = '1' style = "height : 30px; width : 723px;">
				<tr class = "tr_title">
					<td style = "width : 20px;"></td>
					<td class = "td_writer" style = "width : 103px;">이름</td>
					<td class = "td_boardtitle" style = "width : 270px;">이메일</td>
					<td class = "td_date" style = "width : 160px;">가입일</td>
				</tr>
			</table>
			<div style = "overflow : auto; height : 110px; width : 723px;">
				<table  border = '1' style = "width : 723px; height : auto;">
					<c:forEach items = "${userList }" var = "user">
						<c:if test = "${user.user_id ne 'admin' }">
							<tr id = "favoriteBoard" style = "text-align : center;">
								<td style = "width : 20px;"><input type = "checkbox" id = "check" name = "check" onclick = "oneCheckbox(this)" value = "${user.user_id }"></td>
								<td style = "width : 103px;">${user.user_name }</td>
								<td style = "width : 270px; word-break : break-all;">${user.user_email }</td>
								<fmt:formatDate var = "user_date" value = "${user.user_date}" pattern="yyyy-MM-dd HH:mm"/>
								<td style = "width : 160px;">${user_date }</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		<div id = "a2" style = "text-align : right; margin-top : 6px;">
			<input type = "submit" value = "회원추방"/>
		</div> 
	</fieldset>
</form>
<form action = "adminQnaDelete">
	<input type = "hidden" id = "check" name = "check" value = "empty"/>
	<fieldset style = "width : 723px; height : 195px; margin-left : 30%;">
		<legend style = "text-align = center;">[문의사항]</legend>
			<table border = '1' style = "height : 30px; width : 723px;">
				<tr class = "tr_title">
					<td class = "td_select" style = "width : 20px;"></td>
					<td class = "td_writer" style = "width : 103px;">작성자</td>
					<td class = "td_boardtitle" style = "width : 270px;">제목</td>
					<td class = "td_date" style = "width : 160px;">작성일</td>
				</tr>
			</table>
			<div style = "overflow : auto; height : 110px; width : 723px;">
				<table  border = '1' style = "width : 723px; height : auto;">
					<c:forEach items = "${qnaList }" var = "qna">
						<tr style = "text-align : center;">
							<td style = "width : 20px;"><input type = "checkbox" id = "check" name = "check" onclick = "oneCheckbox(this)" value = "${qna.qnaNumber }"></td>
							<td style = "width : 103px;">${qna.qnaWriter }</td>
							<td style = "width : 270px; word-break : break-all;"><a href = "adminQnaOpen?id=${qna.qnaUserId }&number=${qna.qnaNumber }">${qna.qnaTitle }</a>
							<c:if test = "${qna.qnaComment ne 'empty' }">
								[답변완료]
							</c:if>
							</td>
							<fmt:formatDate var = "qna_date" value = "${qna.qnaDate}" pattern="yyyy-MM-dd HH:mm"/>
							<td style = "width : 160px;">${qna_date }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style = "text-align : right; margin-top : 6px;">
				<input type = "submit" value = "삭제"/>
			</div>
	</fieldset>
</form>
</body>
</html>