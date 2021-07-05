<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<style>
	.userIdInfo {
		width : 98%;
		text-align : center;
		padding : 20px;
		margin : 15px;
	}
	.in {
		display : inline-block;
		width : 20%;
		border : 1px solid black;
		height : auto;
	}
	.fontstyle {
		color : blue;
	}
	
</style>
</head>
<body>
<img alt = "title" src = "${togetherPeopleTitle}" style = "width : 100%; height : 200px;">
	<hr>
	
	<div class = "userIdInfo">
		<div class = "in">
			<span class = "fontstyle">${user.user_name }</span>님<br>
			 저희 TOGETHER PEOPLE에 오신걸 환영합니다.<br>
			 즐거운 시간 되시길 바랍니다.^^<br>
		</div>
	</div>
	
	<div style = "text-align : center; width : 100%; height : auto;">
		<a href = "loginView">로그인</a>
	</div>
</body>
</html>