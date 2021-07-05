<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스팅 삭제</title>
<script>
	function postingCancel() {
		window.close();
	}
	function postingSuccess() {
		opener.location.reload();
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
	.postingCc1, .postingCc2 {
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
	<form action = "deletePostingForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">

<hr>
	
	<h4>포스팅 삭제</h4>
	
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "hidden" id = "user_name" name = "user_name" value = "${userInfo.user_name }"/>
	<input type = "hidden" id = "postingRecommandCount" name = "postingRecommandCount" value = "${postingInfo.postingRecommandCount }"/>
	<input type = "hidden" id = "postingNumber" name = "postingNumber" value = "${postingInfo.postingNumber }"/>
	<input type = "text" id = "postingContent" name = "postingContent" value = "정말 삭제하시겠습니까?"/>
	<div><br><br></div>
	
	<input type = "submit" class = "postingCc1" onclick = "postingSuccess()" value = "삭제"/>
	
	<input type = "button" class = "postingCc2" onclick = "postingCancel()" value = "취소"/>
	
	</form>
</body>
</html>