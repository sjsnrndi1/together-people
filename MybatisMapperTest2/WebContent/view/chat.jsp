<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>${boardInfo.boardTitle } - 채팅방</title>
    <script>
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
	.kategorie {
		width : 98%;
		text-align : center;
		padding : 20px;
		margin : 15px;
	}
	.notice, .board {
		display : inline-block;
		width : 25%;
		height : auto;
	}
	.mypage {
		display : inline-block;
		width : 25%;
		height : auto;
		margin-top : 20px;
	}
	.chatTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	#messageWindow {
		align : center;
		resize : none;
	}
	#profile {
		width : 60px;
		height : 66px;
		text-align : center;
		vertical-align : bottom;
	}
    </style>
</head>
<body>
<form action = "chatSave">
	<div style = "float : left; width : 17%; height : 150px;">
		<a href = "mainView?id=${userInfo.user_id }"><img alt = "title" src = "${togetherPeopleTitle}" style = "width : 100%; height : 150px;"></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 20%; height : 150px;">		
		<a href = "chatJoinCloseNoticeView?id=${userInfo.user_id }&number=${boardInfo.boardNumber }"><img alt = "공지사항" src = "${togetherPeopleNotice }" ></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 25%; height : 150px;">		
		<a href = "chatJoinCloseBoardView?id=${userInfo.user_id }&number=${boardInfo.boardNumber }&subject=all"><img alt = "게시판" src = "${togetherPeopleBoard }" ></a>
	</div>
	
	<div style = "float : left; text-align : left; width : 37.5%; height : 150px; margin-top : 13px;">	
		<c:if test = "${userInfo.user_id ne 'admin' }">	
			<a href = "chatJoinCloseMypageView?id=${userInfo.user_id }&number=${boardInfo.boardNumber }"><img alt = "마이페이지" src = "${togetherPeopleMypage }" ></a>
		</c:if>
		<c:if test = "${userInfo.user_id eq 'admin' }">
			<a href = "managementView"><img alt = "관리" src = "${togetherPeopleManagement }" ></a>
		</c:if>
	</div>
		
<div style = "float : left; width : 100%; height : 60px; text-align : right; position: relative;">
	<div style = "text-align : center; font-size : 20px;">
		<MARQUEE behavior="scroll">TOGETHER PEOPLE에 오신것을 환영합니다! 현재 코로나 때문에 힘든 상황이지만 모두 다함께 이겨내보아요! 아자아자 화이팅!</MARQUEE>
	</div>
	<div style = "margin-right : 1%;">
		<c:if test = "${userInfo.user_id ne 'admin' }">	
			<a href = "mypageView?id=${userInfo.user_id }">${userInfo.user_name }</a>님 
		</c:if>
		<c:if test = "${userInfo.user_id eq 'admin' }">	
			<a href = "managementView">관리자</a>
		</c:if>
		<img src = "${alarmClose }" alt = "알람" style = "background : no-repeat; width : 20px; hegith : 20px;" onclick = "alarmToggle()">
	</div>
	<div id = "alarm" style = "border : 2px solid black; width : 350px; height : 300px; position: relative; left:80.5%; top: 5px; display:none;">
		<div style = "text-align : left; width : 100%; height : 80%; overflow : auto;">
			<c:forEach items = "${alarms }" var = "alarm">
				<fmt:formatDate var = "alarmDate" value = "${alarm.alarmDate}" pattern="MM월dd일 HH:mm"/>
				<textarea style = "text-align : left; width : 98%; height : 60px; resize : none; " readonly>
${alarm.alarmContent }
						${alarmDate }</textarea>
			</c:forEach>
		</div>
		<hr>
		<a href = "chatJoinCloseLoginView?id=${userInfo.user_id }&number=${boardInfo.boardNumber }" style = "margin-right : 5%;">로그아웃</a>
	</div>
</div>
	<hr>
	<div class = "chatTitle">
		채팅방
	</div>
	<hr>
    <fieldset style = "width : 675px; height : 180px; margin-left : 30%;">
        <textarea id="messageWindow" rows="10" cols="100" readonly>
${userInfo.user_name }님이 채팅방에 참여하였습니다.
<c:forEach items = "${chatList }" var = "chat">
${chat.chatUserId } : ${chat.chatContent }</c:forEach>
        </textarea>
        <br/>
        <input type = "hidden" id = "boardNumber" name = "boardNumber" value = "${boardInfo.boardNumber }"/>
        <input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
        <input type = "hidden" id = "user_name" name = "user_name" value = "${userInfo.user_name }"/>
		<input id="inputMessage" name = "inputMessage" type="text" onkeydown = "enterkey()" style = "width : 670px;"/>
        <input type="submit" value="입력" onclick="send()"/>
    </fieldset>
    <fieldset style = "width : 723px; height : 80px; margin-left : 30%;">
    	<legend style = "text-align = center;">[채팅 참여자 목록]</legend>
    		<textarea rows = "4" cols = "90" readonly style = "resize : none; border : 1px black white; vertical-align : bottom;">
${boardInfo.boardWriter },<c:forEach items = "${boardJoinUserList }" var = "boardJoinUser"><c:if test = "${boardJoinUser.chatJoinCheck eq 2 }">${boardJoinUser.boardJoinUser_name },</c:if></c:forEach>
    		</textarea>
    </fieldset>
    <hr>
    <div style = "text-align : center;">
    	<a href = "chatJoinClose?id=${userInfo.user_id }&number=${boardInfo.boardNumber }"><input type = "button" value = "뒤로가기"/></a>
    </div>
    </form>
</body>
    <script type="text/javascript">
        var textarea = document.getElementById("messageWindow");
        var user_name = document.getElementById("user_name").value;
        var user_id = document.getElementById("user_id").value;
        var webSocket = new WebSocket('ws://localhost:8088/MybatisMapperTest/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
    	var message = event.data.split("|");
    	var sender = message[0];
        var content = message[1];
        if(content == ""){
        	
        } else {
        	textarea.value += sender + " : " + content + "\n";        	
        }
    }
    function onOpen(event) {
        //textarea.value += user_name + "님이 채팅방에 참여하였습니다." + "\n";
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
    	if(inputMessage.value == ""){

    	} else {
	        textarea.value += user_name + " : " + inputMessage.value + "\n";
	        webSocket.send(user_id + "|" + inputMessage.value);
    		document.getElementById("chatInput").disabled = 'disabled';
    	}
    }
    function enterkey() {
        if (window.event.keyCode == 13) {
            send();
        }
    }
    window.setInterval(function() {
        var elem = document.getElementById("messageWindow");
        elem.scrollTop = elem.scrollHeight;
    }, 0);
    window.onload = function() {
    	  var input = document.getElementById("inputMessage").focus();
    }
  </script>