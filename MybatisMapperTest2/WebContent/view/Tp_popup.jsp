<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Together people 톡</title>
<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css"> <!-- 폰트 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/submenubar.css"> <!-- 우측서브메뉴바 -->
</head>
<style>
	body {
		margin : 0;
		padding : 0;
		overflow : hidden;
	}
</style>
<body>
	<c:set var="now" value="<%= new java.util.Date() %>" />
	<div style = "width : 450px; height : 800px; background-color :	#696969;"> 
		<div class = "submenu-chat-title" style = "height : 5%; text-align : center; color : #ffffff; padding : 10px; width : 100%; font-size : 140%;">
			Together people 톡
		</div>
		<div class = "submenu-chat-content-frame" style = "padding-top : 10px; height : 84%; overflow-y : scroll; overflow : hidden; background-color : #FFFAFA; width : 100%;">

			<div style = "text-align : center; padding : 0;">
				<div style = "float : left; width : 130px; border : 1px solid #696969; margin-top : 10px;"></div>
				<fmt:formatDate value="${now}" type="date" dateStyle="full" />
				<div style = "float : right; width : 130px; border : 1px solid #696969; margin-top : 10px;"></div>
			</div>
			<c:forEach items = "${popupChatList }" var = "popupChat">
				<c:if test = "${popupChat.userChatContent ne null }">
					<div class = "submenu-chat-user-frame" style = "margin : 3px; float : right; width : 90%; border-radius : 5px;">
						<div class = "submenu-chat-user-content-frame-right" style = "float : right; text-align : right; max-width : 80%; border-radius : 5px;">
							<div class = "submenu-chat-user-content-right" style = "font-size : 100%; padding : 4px; background-color : #666; color : #fffff0; text-align : right; width : auto; border : 1px solid #DCDCDC; border-radius : 5px;">
								${popupChat.userChatContent }
							</div>
						</div>
						<div class = "submenu-chat-user-time-frame-right" style = "float : right; margin-right : 3px; text-align : right; width : 18%; border-radius : 5px;">
							<div class = "submenu-chat-user-time-right"  style = "font-size : 80%; width : 100%; color : black; text-align : right; border-radius : 5px;">
								<fmt:formatDate value="${popupChat.chat_date}" pattern="a h:mm" />
							</div>
						</div>
					</div>
				</c:if>
				<c:if test = "${popupChat.adminChatContent ne null }">
					<div class = "submenu-chat-admin-frame" style = "margin : 3px; float : left; width : 90%; border-radius : 5px;">
						<div class = "submenu-chat-admin-content-frame-left" style = "float : left; text-align : left; max-width : 80%; border-radius : 5px;">
							<div class = "submenu-chat-user-content-left" style = "font-size : 100%; padding : 4px; background-color : #666; color : #fffff0; text-align : left; width : auto; border : 1px solid #DCDCDC; border-radius : 5px;">
								${popupChat.adminChatContent }
							</div>
						</div>
						<div class = "submenu-chat-user-time-frame-left" style = "float : left; margin-left : 3px; text-align : left; width : 18%; border-radius : 5px;">
							<div class = "submenu-chat-user-time-left" style = "font-size : 80%; width : 100%; color : black; text-align : left; border-radius : 5px;">
								<fmt:formatDate value="${popupChat.chat_date}" pattern="a h:mm" />
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<hr>
		<form action = "popup_user_chat_input_form" method = "POST">
			<div class = "submenu-chat-input-frame" style = "position : absolute; width : 100%; bottom : 0; height : 5%;">
				<div style = "float : left; border : 1px solid #FFFAFA; border-radius : 3px; width : 90%; height : 90%; overflow : hidden;">
					<input type = "hidden" value = "${user_id }" id = "user_id" name = "user_id" />
					<input type = "text" value = "" placeholder = "메세지를 입력하세요." autofocus id = "user_chat" class = "user_chat" name = "user_chat" style = "width : 100%; height : 90%; overflow : hidden; border-radius : 3px; border : 1px solid #FFFAFA;"/>
				</div>
				<div style = "float : left; width : 8.5%; margin-left : 4px; padding : 0; height : 100%; border-radius : 5px;">
					<input type ="submit" value = "▶" style = "width : 100%; padding-bottom : 4px; border-radius : 5px; height : 95%; border : 1px solid #FFFAFA;"/>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>