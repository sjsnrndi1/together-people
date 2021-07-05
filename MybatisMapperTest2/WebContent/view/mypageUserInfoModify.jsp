<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script>
	function minusCut(loc) {
		if(/[^0123456789]/g.test(loc.value)) {
			alert("숫자가 아닙니다.\n\n숫자만 입력해주십시오.");
			loc.value = "";
			loc.focus(); 
		}
		document.getElementById("signUp").disabled = 'disabled';
		document.getElementById("allAddCheck").disabled = false;
	}
	function passwordQuestionCheck(){
		var a = document.getElementById("user_passwordQuestion");
		if(a.value == "질문"){
			alert("질문을 선택해주세요.");
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
	.userModifyTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	.td_title{
		width : 150px;
		text-align : center;
	}
	
</style>
</head>
<body>
<form action = "userInfoModifyForm">
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
	<div class = "userModifyTitle">
		회원정보 수정
		<hr>
	</div>
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<fieldset style = "width : 675px; height : auto; margin-left : 33%;">
		<legend style = "text-align = center;">[회원 정보]</legend>
			<table border = '1' style = "text-align : center;">
				<tr>
					<td class = "td_title">이름</td>
					<td colspan = "2"><input style = "width : 500px;" id = "user_name" name = "user_name" type = "text" value = "${userInfo.user_name }"/></td>
				</tr>
				<tr>
					<td class = "td_title">주소</td>
					<td><input style = "width : 125px;" type = "text" id = "user_postNumber" name = "user_postNumber" value = "${userInfo.user_postNumber }" readonly/>
					-
					<input style = "width : 125px;" type = "text" id = "user_address" name = "user_address" value = "${userInfo.user_address }" readonly/>
					-
					<input style = "width : 125px;" type = "text" id = "user_detailAddress" name = "user_detailAddress" value = "${userInfo.user_detailAddress }" readonly/></td>
					<td style = "width : 55px;"><a href = "selectAddress" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" value = "주소검색"/></a></td>
				</tr>
				<tr>
					<td class = "td_title">이메일</td>
					<td colspan = "2"><input style = "width : 500px;" id = "user_email" name = "user_email" type = "text" value = "${userInfo.user_email }"/></td>
				</tr>
				<tr>
					<td class = "td_title">전화번호</td>
					<td colspan = "2"><input style = "width : 500px;" id = "user_phone" name = "user_phone" type = "text" value = "${userInfo.user_phone }" onblur = "minusCut(this)"/></td>
				</tr>
				<tr>
					<td class = "td_title">비밀번호질문선택</td>
					<td colspan = "2">
					<select name = "user_passwordQuestion" id = "user_passwordQuestion" style = "width : 500px;">
						<option value = "질문">비밀번호 질문 선택</option>
						<option value = "질문1">당신이 가장 좋아하는 음식은?</option>
						<option value = "질문2">무인도에 어쩔 수 없이 가야하는 상황에 가지고가야할 1순위는?</option>
						<option value = "질문3">당신이 좋아하는 사람의 이름은?</option>
						<option value = "질문4">그 누구도 모르는 나 자신밖에 모르는 비밀은?</option>
						<option value = "질문5">부모님의 고향은?</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class = "td_title">비밀번호답변</td>
					<td colspan = "2"><input style = "width : 500px;" id = "user_answer" name = "user_answer" type = "text" value = "${userInfo.user_answer }"/></td>
				</tr>
			</table>
		<div style = "text-align : center; margin-top : 6px;">
			<input type = "submit" value = "회원정보수정" onclick = "passwordQuestionCheck()"/>
			<a href = "mypageView?id=${userInfo.user_id }"><input type = "button" value = "뒤로가기"/></a>
		</div>
	</fieldset>
</form>
</body>
</html>