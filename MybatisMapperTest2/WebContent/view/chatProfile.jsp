<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 참여자 명단</title>
<script>
	function joinUserListClose() {
		opener.location.href = "http://localhost:8088/MybatisMapperTest/boardOpen?number=${boardInfo.boardNumber}&id=${userInfo.user_id}";
		window.close();
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
	h4 {
		text-align : center;
	}
	.windowClose {
		text-align : center;
		margin-left : 43%;
	}
	.userName {
		text-align : center;
		width : 270px;
	}
	.table_title {
		width : 270px;
		text-align : center;
	}
</style>
</head>
<body>
	<form action = "boardJoinUserForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">
	<hr>
	<h4>게시글 참여자 명단</h4>
	<table border = '1' style = "width : 100%;">
	<tr class = "table_title">
		<td style = "width : 210px;">참여자 이름</td>
		<td colspan = "2"></td>
	</tr>
	</table>
	<table border = '1' style = "width : 100%;">
		<c:forEach items = "${boardJoinUsers }" var = "boardJoinUser">
			<c:if test = "${boardJoinUser.boardJoinUserCheck eq 2}">
				<tr>
				<td class = "userName" style = "width : 210px;">${boardJoinUser.boardJoinUser_name }</td>
				<td style = "text-align : center;"><a href = "userBoardOut?id=${userInfo.user_id }&boardJoinUser_id=${boardJoinUser.boardJoinUser_id}&number=${boardInfo.boardNumber }">
					<input type = "button" value = "회원추방"/></a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<div><br><br></div>
	
	<input type = "button" class = "windowClose" onclick = "joinUserListClose()" value = "닫기"/>
	
	</form>
</body>
</html>