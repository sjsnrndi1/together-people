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
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/popupChatbar.css"> <!-- 팝업 창 화면바 -->
</head>
<style>
	.popup-chat-content-frame {
		overflow-x : hidden;
	}
	
	.bottomView{
		border : 1px solid white;
		width : 100%;
	}
	input:focus {
		outline : none;
	}
</style>
<body>
	<input type = "hidden" value = "${ssVar}"/>
	<div class = "popup-frame"> 
		<div class = "popup-chat-title">
			Together people 톡
		</div>
		<div class = "popup-chat-content-frame">
			<c:forEach items = "${popupChatList }" var = "popupChat" varStatus = "status">
					<c:if test = "${yMd_list_ResultMap.yMd_Result_Date[status.index] ne 'noDate' }">
						<div class = "popup-fulltime-frame">
							<div class = "popup-fulltime-line-left"></div>
								${yMd_list_ResultMap.yMd_Result_Date[status.index] }
							<div class = "popup-fulltime-line-right"></div>
						</div>
					</c:if>
					<c:if test = "${popupChat.userChatContent ne null }">
						<fmt:formatDate var = "nowDate" value="${popupChat.chat_date}" pattern="yyyy-MM-dd" />
						<c:if test = "${nowDate eq yMd_listMap.yMdDate[status.index]}">
							<div class = "popup-chat-user-frame">
								<div class = "popup-chat-user-frame-right">
									<div class = "popup-chat-user-content">
										${popupChat.userChatContent }
									</div>
								</div>
								<div class = "popup-chat-user-time-frame-right">
									<div class = "popup-chat-user-time-content">
										<fmt:formatDate value="${popupChat.chat_date}" pattern="a h:mm" />
									</div>
								</div>
							</div>
						</c:if>
					</c:if>
					<c:if test = "${popupChat.adminChatContent ne null }">
						<fmt:formatDate var = "nowDate" value="${popupChat.chat_date}" pattern="yyyy-MM-dd" />
						<c:if test = "${nowDate eq yMd_listMap.yMdDate[status.index]}">
							<div class = "popup-chat-admin-frame">
								<div class = "popup-chat-admin--frame-left">
									<div class = "popup-chat-admin-content">
										${popupChat.adminChatContent }
									</div>
								</div>
								<div class = "popup-chat-admin-time-frame-left">
									<div class = "popup-chat-admin-time-content">
										<fmt:formatDate value="${popupChat.chat_date}" pattern="a h:mm" />
									</div>
								</div>
							</div>
						</c:if>
					</c:if>
			</c:forEach>
			<input type = "text" value = "" readonly autofocus class = "bottomView" />
		</div>
		
		<hr>
		
		<form action = "popup_user_chat_input_form" method = "POST">
			<div class = "popup-chat-input-frame">
				<div class = "popup-chat-input">
					<input type = "hidden" value = "${user_id }" id = "user_id" name = "user_id" />
					<input type = "text" value = "" placeholder = "메세지를 입력하세요." autofocus id = "user_chat" class = "user_chat" name = "user_chat"/>
				</div>
				<div class = "popup-chat-input-btn">
					<input type = "submit" value = "▶" class = "popup-chat-btn"/>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>