<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script>
	function us() {
		opener.location.href = "http://localhost:8088/MybatisMapperTest/loginView";
		window.close();
	}
</script>
<style>
	h4 {
		text-align : center;
	}
	#postingContent {
		width : 90%;
		height : auto;
		margin : 5%;
		border : 1px solid white;
		text-align : center;
	}
	.userSc {
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
	<form action = "userSecessionForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">

<hr>
	
	<h4>회원탈퇴</h4>
	
<hr>
	
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "text" id = "postingContent" name = "postingContent" value = "정말 탈퇴하시겠습니까?"/>
	<div><br><br></div>
	
	<input type = "submit" class = "userSc" onclick = "us()" value = "탈퇴"/>
	
	<input type = "button" class = "userSc" onclick = "window.close()" value = "닫기"/>
	
	</form>
</body>
</html>