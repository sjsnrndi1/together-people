<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<script>
	function boardSuccess() {
		opener.location.href = "http://localhost:8088/MybatisMapperTest/boardView?id=${userInfo.user_id}&subject=all";
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
	.delete, .cancel {
		text-align : center;
		margin-left : 27%;
	}
</style>
</head>
<body>
	<form action = "boardDeleteForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">

<hr>
	
	<h4>게시글 삭제</h4>
	
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "hidden" id = "boardNumber" name = "boardNumber" value = "${boardInfo.boardNumber }"/>
	<input type = "text" id = "boardContent" name = "boardContent" value = "정말 삭제하시겠습니까?" readOnly/>
	<div><br><br></div>
	
	<input type = "submit" class = "delete" onclick = "boardSuccess()" value = "삭제"/>
		
	<input type = "button" class = "cancel" onclick = "window.close()" value = "취소"/>
	
	</form>
</body>
</html>