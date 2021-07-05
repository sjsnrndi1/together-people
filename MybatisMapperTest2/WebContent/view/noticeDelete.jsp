<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 삭제</title>
<script>
	function noticeSuccess() {
		opener.location.href = "http://localhost:8088/MybatisMapperTest/noticeView?id=${userInfo.user_id}";
		window.close();
	}
</script>
<style>
	h4 {
		text-align : center;
	}
	#noticeContent {
		width : 90%;
		height : auto;
		margin : 5%;
		border : 1px solid white;
		text-align : center;
	}
	.delete, .cancel {
		text-align : center;
		margin-left : 27%;
	}
	#byteInfo {
		text-align : center;
		padding-left : 80%;
	}
	#byteInfo2 {
		text-align : center;
		padding-right : 10%;
	}
</style>
</head>
<body>
	<form action = "noticeDeleteForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">

<hr>
	
	<h4>공지사항 삭제</h4>
	
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "hidden" id = "noticeNumber" name = "noticeNumber" value = "${noticeInfo.noticeNumber }"/>
	<input type = "text" id = "noticeContent" name = "noticeContent" value = "정말 삭제하시겠습니까?"/>
	<div><br><br></div>
	
	<input type = "submit" class = "delete" onclick = "noticeSuccess()" value = "삭제"/>
	
	<input type = "button" class = "cancel" onclick = "window.close()" value = "취소"/>
	
	</form>
</body>
</html>