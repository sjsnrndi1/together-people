<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 참여 완료</title>
<script>
	function boardSuccess() {
		opener.location.href = "http://localhost:8088/MybatisMapperTest/boardJoinUserList?number=${boardInfo.boardNumber}";
		window.close();
	}
</script>
<style>
	h4 {
		text-align : center;
	}
	#boardContent {
		width : 90%;
		height : auto;
		margin : 5%;
		border : 1px solid white;
		text-align : center;
	}
	.boardCc1, .boardCc2 {
		text-align : center;
		margin-left : 27%;
	}
</style>
</head>
<body>
	<form action = "successJoinUserForm" method = "POST">
	<img alt = "title" src = "images/bg.PNG" style = "width : 100%; height : 200px;">

<hr>
	
	<h4>게시글 참여 수락 확인</h4>
	
	<input type = "hidden" id = "board_number" name = "board_number" value = "${boardInfo.boardNumber }"/>
	<input type = "hidden" id = "boardJoinUser_id" name = "boardJoinUser_id" value = "${boardJoinUserInfo.boardJoinUser_id }"/>
	<input type = "text" id = "boardContent" name = "boardContent" value = "모임에 참여시키겠습니까?"/>
	<div><br><br></div>
	
	<input type = "submit" class = "boardCc1" onclick = "boardSuccess()" value = "수락"/>
	
	<input type = "button" class = "boardCc2" onclick = "window.close()" value = "취소"/>
	
	</form>
</body>
</html>