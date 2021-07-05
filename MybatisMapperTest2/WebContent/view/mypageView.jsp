<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script>
	function oneCheckbox(a){
	    var obj = document.getElementsByName("check");
	    for(var i = 0; i < obj.length; i++){
	        if(obj[i] != a){
	            obj[i].checked = false;
	        }
	    }
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
	.mypageTitle {
		width : 60%;
		height : auto;
		text-align : center;
		margin : auto;
	}
	.logout {
		text-align : center;
		padding-left : 90%;
	}
	.userTable{
		width : 723px;
		height : 100px;
		margin : auto;
	}
	#commandArea{
		height : 30px;
		text-align : right;
	}
	.td_title{
		width : 100px;
		text-align : center;
	}
	.tr_title{
		height : 30px;
		text-align : center;
	}
	.td_writer, .td_boardtitle, .td_date, .td_favorite{
		text-align : center;
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
	<div class = "mypageTitle">
		마이페이지
	</div>
		<hr>
	<fieldset style = "width : 723px; height : 160px; margin-left : 30%;">
		<legend style = "text-align = center;">[회원 정보]</legend>
			<table border = '1' class = "userTable">
				<tr>
					<td class = "td_title">이름</td>
					<td>${userInfo.user_name }</td>
				</tr>
				<tr>
					<td class = "td_title">주소</td>
					<td>${userInfo.user_postNumber }-${userInfo.user_address }-${userInfo.user_detailAddress }</td>
				</tr>
				<tr>
					<td class = "td_title">이메일</td>
					<td>${userInfo.user_email }</td>
				</tr>
				<tr>
					<td class = "td_title">전화번호</td>
					<td>${userInfo.user_phone }</td>
				</tr>
			</table>
		<div style = "text-align : right; margin-top : 6px;">
			<a href = "userInfoModify?id=${userInfo.user_id }"><input type = "button" value = "회원정보수정"/></a>
		</div>
	</fieldset>
	<form action = "mypageBoardDelete">
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<fieldset style = "width : 723px; height : 195px; margin-left : 30%;">
		<legend style = "text-align = center;">[즐겨찾기]</legend>
			<table border = '1' style = "height : 30px; width : 723px;">
			<c:if test = "${recommand eq 'recommand' }">
				<tr class = "tr_title">
					<td class = "td_writer" style = "width : 123px;">작성자</td>
					<td class = "td_boardtitle" style = "width : 270px;">제목</td>
					<td class = "td_date" style = "width : 160px;">작성일</td>
					<td class = "td_favorite" style = "width : 170px;">즐겨찾기</td>
				</tr>
			</c:if>
			<c:if test = "${recommand ne 'recommand' }">
				<tr class = "tr_title">
					<td class = "td_select" style = "width : 20px;"></td>
					<td class = "td_writer" style = "width : 103px;">작성자</td>
					<td class = "td_boardtitle" style = "width : 270px;">제목</td>
					<td class = "td_date" style = "width : 160px;">작성일</td>
					<td class = "td_favorite" style = "width : 170px;">회원 수</td>
				</tr>
			</c:if>
			</table>
			<div style = "overflow : auto; height : 110px; width : 723px;">
				<table  border = '1' style = "width : 723px; height : auto;">
					<c:forEach items = "${boardList }" var = "board">
						<c:if test = "${recommand eq 'recommand' }">
							<tr id = "favoriteBoard" style = "text-align : center;">
								<td style = "width : 123px;">${board.boardWriter }</td>
								<td style = "width : 270px; word-break : break-all;">
									<a href = "boardOpen?id=${userInfo.user_id }&number=${board.boardNumber }">${board.boardTitle }</a>
								</td>
								<fmt:formatDate var = "board_date" value = "${board.boardDate }" pattern="yyyy-MM-dd HH:mm"/>
								<td style = "width : 160px;">${board_date }</td>
								<td style = "width : 170px;"><a href = "mypageFavoriteCancel?id=${userInfo.user_id }&number=${board.boardNumber }"><input type = "button" value = "취소"/></a></td>
							</tr>
						</c:if>
						<c:if test = "${recommand ne 'recommand' && board.boardUserId eq userInfo.user_id}">
							<tr id = "favoriteBoard" style = "text-align : center;">
								<td style = "width : 20px;"><input type = "checkbox" id = "check" name = "check" onclick = "oneCheckbox(this)" value = "${board.boardNumber }"></td>
								<td style = "width : 103px;">${board.boardWriter }</td>
								<td style = "width : 270px; word-break : break-all;">
									<a href = "boardOpen?id=${userInfo.user_id }&number=${board.boardNumber }">${board.boardTitle }</a>
								</td>
								<fmt:formatDate var = "board_date" value = "${board.boardDate }" pattern="yyyy-MM-dd HH:mm"/>
								<td style = "width : 160px;">${board_date }</td>
								<td style = "width : 170px;">${board.boardJoinUserNumber }</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<c:if test = "${recommand eq 'recommand' }">
				<div id = "a1" style = "text-align : right; margin-top : 6px;">
					<a href = "mypageUserBoard?id=${userInfo.user_id }"><input type = "button" value = "내 게시글 보기"/></a>
				</div>
			</c:if>
			<c:if test = "${recommand ne 'recommand' }">
				<div id = "a2" style = "text-align : right; margin-top : 6px;">
					<a href = "mypageView?id=${userInfo.user_id }"><input type = "button" value = "즐겨찾기" /></a>
					<input type = "submit" value = "삭제" />
				</div>
			</c:if>
	</fieldset>
	<input type = "hidden" id = "check" name = "check" value = "empty"/>
	</form>
	<form action = "mypageDeletePosting">
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<fieldset style = "width : 723px; height : 195px; margin-left : 30%;">
		<legend style = "text-align = center;">[포스팅]</legend>
			<table border = '1' style = "height : 30px; width : 723px;">
				<tr class = "tr_title">
					<td class = "td_select" style = "width : 20px;"></td>
					<td class = "td_writer" style = "width : 103px;">작성자</td>
					<td class = "td_boardtitle" style = "width : 270px;">내용</td>
					<td class = "td_date" style = "width : 160px;">작성일</td>
					<td class = "td_favorite" style = "width : 170px;">추천수</td>
				</tr>
			</table>
			<div style = "overflow : auto; height : 110px; width : 723px;">
				<table  border = '1' style = "width : 723px; height : auto;">
					<c:forEach items = "${postingList }" var = "posting">
						<c:if test = "${posting.userId eq userInfo.user_id }">
							<tr style = "text-align : center;">
								<td style = "width : 20px;"><input type = "checkbox" id = "check" name = "check" onclick = "oneCheckbox(this)" value = "${posting.postingNumber }"></td>
								<td style = "width : 103px;">${posting.userName }</td>
								<td style = "width : 270px; word-break : break-all;">${posting.postingContent }</td>
								<fmt:formatDate var = "posting_date" value = "${posting.postingDate}" pattern="yyyy-MM-dd HH:mm"/>
								<td style = "width : 160px;">${posting_date }</td>
								<td style = "width : 170px;">${posting.postingRecommandCount }</td>
							</tr>
						</c:if>
					</c:forEach>
					<c:forEach items = "${postingRecommandList }" var = "postingRecommand">
						<tr style = "text-align : center;">
							<td style = "width : 20px;"></td>
							<td style = "width : 103px;">${postingRecommand.userName }</td>
							<td style = "width : 270px; word-break : break-all;">${postingRecommand.postingContent }</td>
							<fmt:formatDate var = "postingRecommand_date" value = "${postingRecommand.postingDate}" pattern="yyyy-MM-dd HH:mm"/>
							<td style = "width : 160px;">${postingRecommand_date }</td>
							<td style = "width : 170px;">${postingRecommand.postingRecommandCount }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style = "text-align : right; margin-top : 6px;">
				<input type = "submit" value = "삭제"/>
			</div>
			<input type = "hidden" id = "check" name = "check" value = "empty"/>
	</fieldset>
	</form>
	<fieldset style = "width : 723px; height : 60px; margin-left : 30%;">
		<legend style = "align : center;">[기타사항]</legend>
			<div style = "text-align : center; height : 40px; width : 255px; float : left;">
				<a href = "qnaView?id=${userInfo.user_id }"><input type = "button" value = "문의사항" style = "width : 100px; height : 40px; font-size : 17px"/></a>
			</div>
			<div style = "text-align : center; height : 40px; width : 200px; float : left;">
				<span style = "color : blue;">TOGETHER PEOPLE</span>을 <br>
				이용해 주셔서 감사합니다!
			</div>
			<div style = "text-align : center; height : 40px; width : 256px; float : left;">
				<a href = "userSecession?id=${userInfo.user_id }" onclick = "window.open(this.href, '_blank', 'width = 400px, height = 550px, toolbars = no, scrollbars = yes'); return false;"><input type = "button" value = "회원탈퇴" style = "width : 100px; height : 40px; font-size : 17px"/></a>
			</div>
	</fieldset>
</body>
</html>