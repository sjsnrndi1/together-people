<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOGETHER PEOPLE</title>
<script>
	function fnChkByte(obj, maxByte)
	{
	    var str = obj.value;
	    var str_len = str.length;
	
	    var rbyte = 0;
	    var rlen = 0;
	    var one_char = "";
	    var str2 = "";
	
	    for(var i = 0; i < str_len; i++)
	    {
	        one_char = str.charAt(i);
	        if(escape(one_char).length > 4) {
	            rbyte += 2;//한글2Byte
	        } else {
	            rbyte++;//영문 등 나머지 1Byte
	        }
	
	        if(rbyte <= maxByte) {
	            rlen = i+1;//return할 문자열 갯수
	        }
	     }
	
	     if(rbyte > maxByte) {
	    	 // alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
	    	 alert("메세지는 최대 " + maxByte + "byte를 초과할 수 없습니다.")
	    	 str2 = str.substr(0, rlen);//문자열 자르기
	    	 obj.value = str2;
	    	 fnChkByte(obj, maxByte);
	     } else {
	        document.getElementById('byteInfo').innerText = rbyte;
	     }
	}
	function count() {
		var hiddenCount = document.getElementById("hiddenCount");
		var rc;
		
		if(hiddenCount.value == 0){
			rc += 1;
			hiddenCount.value = 1;
		} else {
			rc -= 1;
			hiddenCount.value = 0;
		}
		document.getElementById("recommandCount").innerText = rc;
		hiddenCount.innerHTML = hiddenCount.value;
	}
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
	.userInfo {
		display : inline-block;
		width : 9%;
		height : auto;
	}
	.contentView {
		display : inline-block;
		width : 79%;
		height : auto;	
	}
	.modifydeleterecommand {
		display : inline-block;
		width : 11%;
		height : auto;
		border : 1px solid black;
		margin-bottom : 25px;
	}
	.noresize {
		resize : none;
	}
	.posting {
		width : 60%;
		height : auto;
		margin : auto;
		text-align : center;
		border : 1px solid black;	
	}
	#modifyPosting, #deletePosting{
		width : 45%;
		height : auto;
		text-align : center;
	}
	.recommandPosting {
		background : url(${togetherPeopleBeforeRecommand }) no-repeat;
		width : 118px;
		height : 100px;
		text-align : center;
		cursor : pointer;
	}
	.postingTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	#postingRegist {
		width : 8%;
		height : auto;
		text-align : center;
	}
	#recommandCount {
		width : 50px;
		text-align : center;
		border : 1px solid white;
	}
</style>
</head>
<body>
	<div style = "float : left; width : 17%; height : 150px;">
		<a href = "mainView?id=${userInfo.user_id }"><img alt = "title" src = "${togetherPeopleTitle}" style = "width : 100%; height : 150px;"></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 20%; height : 150px;">		
		<a href = "noticeView?id=${userInfo.user_id }"><img alt = "공지사항" src = "${togetherPeopleNotice }" ></a>
	</div>
	
	<div style = "float : left; text-align : center; width : 25%; height : 150px;">		
		<a href = "boardView?id=${userInfo.user_id }&subject=all"><img alt = "게시판" src = "${togetherPeopleBoard }" ></a>
	</div>
	
	<div style = "float : left; text-align : left; width : 37.5%; height : 150px; margin-top : 13px;">	
		<c:if test = "${userInfo.user_id ne 'admin' }">	
			<a href = "mypageView?id=${userInfo.user_id }"><img alt = "마이페이지" src = "${togetherPeopleMypage }" ></a>
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
		<a href = "loginView" style = "margin-right : 5%;">로그아웃</a>
	</div>
</div>
	<hr>
	<div class = "postingTitle">
		당신의 일상을 모두와 자유롭게 공유하세요!
		<c:if test = "${userInfo.user_id ne 'admin' }">
			<a href = "postingRegist?id=${userInfo.user_id }" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" id = "postingRegist" value = "포스팅등록"/></a>
		</c:if>
		<hr>
	</div>
	<!-- for문 쓰기 -->
	<div style = "overflow : auto; width : 100%; height : 600px;">
	<table class = "posting">
		<c:forEach items = "${postingList }" var = "posting">
			<tr>
				<td class = "userInfo">
					<img alt = "시바" src = "images/siba.png" style = "width : 100%; height : auto;"><br>
					${posting.userName }
				</td>
				<td class = "contentView">
					<textarea class = "noresize" rows = "10" cols = "120" readonly>${posting.postingContent }</textarea>
				</td>
				<td class = "modifydeleterecommand">
					<c:choose>
						<c:when test = "${posting.userId == userInfo.user_id }">
							<a href = "modifyPosting?id=${userInfo.user_id }&number=${posting.postingNumber}" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" id = "modifyPosting" value = "수정"/></a>
							<a href = "deletePosting?id=${userInfo.user_id }&number=${posting.postingNumber}" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" id = "deletePosting" value = "삭제"/></a>
							<a href = "postingRecommandCount?id=${userInfo.user_id }&number=${posting.postingNumber}"><img class = "recommandPosting" id = "ci"/></a>
							<input type = "text" id = "recommandCount" name = "recommandCount" value = "${posting.postingRecommandCount }"/>
						</c:when>
						<c:when test = "${posting.userId != userInfo.user_id }">
							<c:if test = "${userInfo.user_id eq 'admin' }">
								<a href = "adminDeletePosting?id=${userInfo.user_id }&number=${posting.postingNumber}"><input type = "button" id = "deletePosting" value = "삭제"/></a>
							</c:if>
							<a href = "postingRecommandCount?id=${userInfo.user_id }&number=${posting.postingNumber}"><input type = "button" class = "recommandPosting"/></a>
							<input type = "text" id = "recommandCount" name = "recommandCount" value = "${posting.postingRecommandCount }"/>
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>