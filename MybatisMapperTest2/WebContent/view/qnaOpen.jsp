<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${qnaInfo.qnaTitle }</title>
<script>
	function answerSuccess(){
		alert("답변을 완료하였습니다.");
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
	<div class = "qnaTitle">
		문의사항 조회
		<hr>
	</div>
	<section id = "contentArea">
	<section id = "basicContent">
		제목 : ${qnaInfo.qnaTitle }<c:if test = "${qnaInfo.qnaComment ne 'no answer' }">[답변완료]</c:if>
	</section>
	<section id = "detailContent">
		${qnaInfo.qnaContent }
	</section>
</section>
<form action = "commentInput">
<input type = "hidden" id = "qna_id" name = "qna_id" value = "${qnaInfo.qnaUserId }"/>
<input type = "hidden" id = "qna_qnaNumber" name = "qna_qnaNumber" value = "${qnaInfo.qnaNumber }"/>
<c:if test = "${admin eq 'admin' }"> <!-- 관리자 -->
	<fieldset style = "width : 545px; height : auto; margin-left : 34.2%;">
		<legend style = "align : center;">[답변]</legend>
			<div style = "overflow : hidden; text-align : center; height : auto;">
				<textarea id="ta" name="ta" style="width:570px;height:32px;overflow-y:hidden;resize:none;">${qnaInfo.qnaComment }</textarea>
				<textarea id="xt" name="xt" style="width:570px;height:1px;overflow-y:hidden;position:absolute;top:-9px" disabled></textarea>
				<script>
					function xSize(e) {
						var xe = document.getElementById('xt'),
						    t;
						e.onfocus = function() {
							t = setInterval(function() {
								xe.value = e.value;
								e.style.height = (xe.scrollHeight + 12) + 'px';
								}, 100);
							}
						e.onblur = function() {
							clearInterval(t);
						}
					}
					xSize(document.getElementById('ta'));
				</script>
			</div>
			<div style = "text-align : right;">
				<input type = "submit" value = "답변" onclick = "answerSuccess();"/>
				<a href = "managementView"><input type = "button" value = "뒤로가기"/></a>
			</div>
	</fieldset>
</c:if>
</form>
<c:if test = "${admin ne 'admin' }"> <!-- 문의사항 생성자 -->
	<fieldset style = "width : 570px; height : auto; margin-left : 34.2%;">
		<legend style = "align : center;">[답변]</legend>
			<div style = "overflow : hidden; text-align : center; height : auto;">
				<textarea id="ta" style="width:570px;height:32px;overflow-y:hidden;resize:none;"readonly>${qnaInfo.qnaComment }</textarea>
				<textarea id="xt" style="width:570px;height:1px;overflow-y:hidden;position:absolute;top:-9px" disabled></textarea>
				<script>
					function xSize(e) {
						var xe = document.getElementById('xt'),
						    t;
						e.onfocus = function() {
							t = setInterval(function() {
								xe.value = e.value;
								e.style.height = (xe.scrollHeight + 12) + 'px';
								}, 100);
							}
						e.onblur = function() {
							clearInterval(t);
						}
					}
					xSize(document.getElementById('ta'));
				</script>
			</div>
			<div style = "text-align : right;">
				<a href = "qnaDelete?id=${userInfo.user_id }&number=${qnaInfo.qnaNumber }"><input type = "submit" value = "삭제"/></a>
				<a href = "qnaView?id=${userInfo.user_id }"><input type = "button" value = "뒤로가기"/></a>
			</div>
	</fieldset>
</c:if>
</body>
</html>