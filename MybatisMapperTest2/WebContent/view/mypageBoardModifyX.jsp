<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 게시글 수정</title>
<script>
	function oneCheckbox(a){
	    var obj = document.getElementsByName("check");
	    for(var i = 0; i < obj.length; i++){
	        if(obj[i] != a){
	            obj[i].checked = false;
	        }
	    }
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
	
	<h4>내 게시글 수정</h4>
	
<hr>

	<fieldset style = "width : 723px; height : 195px; margin-left : 30%;">
		<table border = '1' style = "height : 30px; width : 723px; text-align : center;">
			<tr class = "tr_title">
				<td class = "td_check" style = "width : 20px;"></td>
				<td class = "td_writer" style = "width : 103px;">작성자</td>
				<td class = "td_boardtitle" style = "width : 270px;">제목</td>
				<td class = "td_date" style = "width : 160px;">작성일</td>
				<td class = "td_favorite" style = "width : 170px;">즐겨찾기</td>
			</tr>
		</table>
			<div style = "overflow : auto; height : 110px; width : 723px;">
				<table  border = '1' style = "width : 723px; height : auto;">
					<c:forEach items = "${boardList }" var = "board">
						<c:if test = "${board.boardUserId eq userInfo.user_id }">
							<tr style = "text-align : center;">
								<td style = "width : 20px;"><input type = "checkbox" id = "check" name = "check" onclick = "oneCheckbox(this)" value = "${board.boardNumber }"></td>
								<td style = "width : 103px;">${board.boardWriter }</td>
								<td style = "width : 270px; word-break : break-all;">${board.boardTitle }</td>
								<fmt:formatDate var = "board_date" value = "${board.boardDate }" pattern="yyyy-MM-dd HH:mm"/>
								<td style = "width : 160px;">${board_date }</td>
								<td style = "width : 170px;"><a href = "mypageFavoriteCancel?id=${userInfo.user_id }&number=${board.boardNumber }"><input type = "button" value = "취소"/></a></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div style = "text-align : right; margin-top : 6px;">
				<input type = "submit" value = "수정"/>
			</div>
	</fieldset>
	</form>
</body>
</html>