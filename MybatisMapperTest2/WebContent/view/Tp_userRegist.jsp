<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="http://fonts.googleapis.com/earlyaccess/hanna.css" rel="stylesheet"> <!-- 폰트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- 제이쿼리 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/sidebar.css"> <!-- 사이드바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/titlebar.css"> <!-- 타이틀바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/footerbar.css"> <!-- 바닥바 -->
<link rel = "stylesheet" href = "http://sjsnrndi12.dothome.co.kr/style/dropmenubar.css"> <!-- 서브메뉴바 -->
<script>
	function minusCut(loc) {
		if(/[^0123456789]/g.test(loc.value)) {
			alert("숫자가 아닙니다.\n\n숫자만 입력해주십시오.");
			loc.value = "";
			loc.focus(); 
		}
		document.getElementById("signUp").disabled = 'disabled';
		document.getElementById("allAddCheck").disabled = false;
	}
		
	function userIdCheck() {
		let user_id = document.getElementById("user_id").value;
		let idCheck = true;
		
		<c:forEach items = "${userList}" var = "user">
			if("${user.user_id}" == user_id){
				idCheck = false;
			}
		</c:forEach>
		
		if(user_id.length < 6){
			document.getElementById("user_id_check").innerHTML = '<font color = "red">6~16자 대 소문자, 숫자를 사용하세요.</font>';
		} else if(user_id == "") {
			document.getElementById("user_id_check").innerHTML = '<font color = "red">필히 입력바랍니다.</font>';
		} else if(idCheck == true){
			document.getElementById("user_id_check").innerHTML = '<font color = "blue">사용가능한 아이디입니다.</font>';
		} else if(idCheck == false){
			document.getElementById("user_id_check").innerHTML = '<font color = "red">현재 사용중인 아이디입니다.</font>';
		}
	}
	
	function userPwSetting() {
		let password = document.getElementById("user_password").value;
		if(password.length < 8|| password.length > 16) {
			document.getElementById("user_password_setting").innerHTML = '<font color = "red">8~13자 대 소문자, 숫자, 특수문자를 사용하세요.</font>';
        } else {
        	document.getElementById("user_password_setting").innerHTML = "";	
        }

	}
	
	function checkCapsLock(event) {
		if(event.getModifierState("CapsLock")) {
			document.getElementById("user_password_setting").innerHTML = '<font color = "red">Caps Lock이 켜져 있습니다.</font>';
		} else {
			document.getElementById("user_password_setting").innerHTML = "";
		}
	}
	
	function userPwCheck() {
		let password = document.getElementById("user_password").value;
		let passwordCheck = document.getElementById("user_passwordCheck").value;
		
		if(password == passwordCheck) {
			document.getElementById("user_password_check").innerHTML = '<font color = "blue">비밀번호가 일치합니다.</font>';
		} else {
			document.getElementById("user_password_check").innerHTML = '<font color = "red">비밀번호가 일치하지 않습니다.</font>';
		}
	}
	
	function userBirthday() {
		let user_birthday_year = document.getElementById("user_birthday_year").value;
		let user_birthday_month = document.getElementById("user_birthday_month").value;
		let user_birthday_day = document.getElementById("user_birthday_day").value;
		
		if(user_birthday_year.length < 4 || user_birthday_year < 1900) {
			document.getElementById("user_birthday_check").innerHTML = '<font color = "red">태어난 년도 4자리를 정확하게 입력하세요.</font>';
		} else if(user_birthday_month == "default") {
			document.getElementById("user_birthday_check").innerHTML = '<font color = "red">태어난 월을 선택하세요.</font>';
		} else if(user_birthday_day == "") {
			document.getElementById("user_birthday_check").innerHTML = '<font color = "red">태어난 일(날짜) 2자리를 정확하게 입력하세요.</font>';
		} else {
			document.getElementById("user_birthday_check").innerHTML = "";
		}
	}
	
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
	
	function check(){
		if(userRegistInfo.user_id.value == ""){
			alert("아이디를 입력해주세요.");
			userRegistInfo.user_id.focus();
			return false;
		} else if(userRegistInfo.user_password.value == ""){
			alert("비밀번호를 입력해주세요.");
			userRegistInfo.user_password.focus();
			return false;
		} else if(userRegistInfo.user_passwordCheck.value == ""){
			alert("비밀번호를 입력해주세요.");
			userRegistInfo.user_passwordCheck.focus();
			return false;
		} else if(userRegistInfo.sample4_postcode.value == ""){
			alert("우편번호를 입력해주세요.");
			userRegistInfo.sample4_postcode.focus();
			return false;
		} else if(userRegistInfo.sample4_roadAddress.value == ""){
			alert("도로명주소를 입력해주세요.");
			userRegistInfo.sample4_roadAddress.focus();
			return false;
		} else if(userRegistInfo.sample4_jibunAddress.value == ""){
			alert("지번주소를 입력해주세요.");
			userRegistInfo.sample4_jibunAddress.focus();
			return false;
		} else if(userRegistInfo.user_name.value == ""){
			alert("이름을 입력해주세요.");
			userRegistInfo.user_name.focus();
			return false;
		} else if(userRegistInfo.user_gender.value == ""){
			alert("성별을 선택해주세요.");
			userRegistInfo.user_gender.focus();
			return false;
		} else if(userRegistInfo.user_birthday_year.value == ""){
			alert("태어난 년도를 입력해주세요.");
			userRegistInfo.user_birthday_year.focus();
			return false;
		} else if(userRegistInfo.user_birthday_month.value == ""){
			alert("태어난 월을 선택해주세요.");
			userRegistInfo.user_birthday_month.focus();
			return false;
		} else if(userRegistInfo.user_birthday_day.value == ""){
			alert("태어난 일을 입력해주세요.");
			userRegistInfo.user_birthday_day.focus();
			return false;
		} else if(userRegistInfo.user_phone.value == ""){
			alert("휴대전화를 입력해주세요.");
			userRegistInfo.user_phone.focus();
			return false;
		} else {
			return true;
		}
	}
	function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
</script>
<style>
	.title {
		width : 20%;
		height : 100%;
		margin : auto;
		text-align : center;
		padding-bottom : 5%;
	}
	.user_id_title, .user_name_title, .user_password_title, .user_passwordCheck_title, .user_address_title, .user_email_title, .user_phone_title, .user_gender_title, .user_birthday_title {
		text-align : left;
		width : 50%;
		font-size : 120%;
	}
	.user_id, .user_password, .user_passwordCheck, .user_name, .user_phone, .user_email, .user_signUp{
		text-align : left;
		height : 30px;
		width : 100%;
		border : 1px solid #A9A9A9;
	}
	.user_gender {
		text-align : left;
		height : 43px;
		width : 100%;
		margin : 0px;
	}
	.sample4_postcode {
		width : 15%;
		height : 30px;
		border : 1px solid red;
	}
	.sample4_roadAddress {
		width : 79%;
		height : 30px;
		border : 1px solid blue;
	}
	.sample4_detailAddress, .sample4_jibunAddress {
		width : 97.5%;
		height : 30px;
		margin : auto;
	}
	.user_address_input {
		margin : 0px;
	}
	.user_birthday_year, .user_birthday_day {
		width : 31%;
		height : 30px;
	}
	.user_birthday_month{
		width : 30%;
		height : 36px;
	}
	input:focus {
		outline : 3px solid #F1DBC6;
		border : 1px solid #F1DBC6;
	}
	select {
		color : gray;
	}
	select:focus {
		outline : 3px solid #F1DBC6;
		border : 1px solid #F1DBC6;
	}
	input::placeholder {
		color : gray;
	}
	.user_id_check, .user_password_check, .user_password_setting, .user_birthday_check {
		width : 100%;
		height : 10px;
		text-align : left;
		border:none;
		font-size : 100%;
	}
	.user_signUp{
		text-align : center;
		height : 50px;
		width : 100%;
		font-size : 30px;
		background-color : #F1DBC6;
		color : #696969;
		border : 1px solid #C0C0C0;
	}
</style>
</head>
<body>
<form action = "user_info_regist" name = "userRegistInfo" method = "POST" onsubmit="return check()">
	<header class = "titleBar">
		<div class="dropmenu">
			<ul>
				<li><a href="firstView">TogetherPeople</a></li>
				<li><a href="noticeView" id="current">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					<ul>
						<li><a href="noticeView">CEO</a></li>
						<li><a href="noticeAccessView">ACCESS</a></li>
					</ul>
				</li>
				<li><a href="boardView">공지사항</a></li>
				<li><a href="mypageView">커뮤니티</a></li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><a href="loginView">로그인</a></li>
				<li><a href="userRegist">회원가입</a></li>
				<li><a href ="#" class="openmenu" onclick='openNav()' style = "font-size : 100%;">전체메뉴</a></li>
			</ul>
		</div>
		
		<div id="mysidenav" class="sidenav">
			<a href="firstView">Together People</a>
			<a href="#" class="closebtn" onclick='closeNav()'>x</a>
			<a href="noticeView">소개</a>
			<a href="boardView">공지사항</a>
			<a href="mypageView">커뮤니티</a>			
		</div>					
	</header>
	
	<section class = "title">
		<p class = "user_id_title">아이디</p>
		<input type = "text" id = "user_id" class = "user_id" name = "user_id" maxlength = "16" onblur = "userIdCheck()"/>
		<div class = "user_id_check" id = "user_id_check"></div>
		
		<p class = "user_password_title">비밀번호</p>
		<input type = "password" id = "user_password" class = "user_password" name = "user_password" maxlength = "16" onblur = "userPwSetting()" onKeyUp = "checkCapsLock(event)"/>
		<div class = "user_password_setting" id = "user_password_setting"></div>
		
		<p class = "user_passwordCheck_title">비밀번호 확인</p>
		<input type = "password" id = "user_passwordCheck" class = "user_passwordCheck" name = "user_passwordCheck" maxlength = "16" onblur = "userPwCheck()" onKeyUp = "checkCapsLock(event)"/>
		<div class = "user_password_check" id = "user_password_check"></div>
		
		<p class = "user_address_title">주소 &nbsp;&nbsp;<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></p>
			<input type = "text" id = "sample4_postcode" class = "sample4_postcode" name = "sample4_postcode" placeholder = "우편번호">
			<input type = "text" id = "sample4_roadAddress" class = "sample4_roadAddress" name = "sample4_roadAddress" placeholder = "도로명주소">
			<input type = "text" id = "sample4_jibunAddress" class = "sample4_jibunAddress" name = "sample4_jibunAddress" placeholder = "지번주소">
			<span id = "guide" style = "color : #999; display : none"></span>
			<input type = "text" id = "sample4_detailAddress" class = "sample4_detailAddress" name = "sample4_detailAddress" placeholder = "상세주소">
			<script src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

		<p class = "user_name_title">이름</p>
		<input type = "text" id = "user_name" class = "user_name" name = "user_name"/>
		
		<p class = "user_gender_title">성별</p>
		<select id = "user_gender" class = "user_gender" name = 'user_gender'>
		      <option value = "default"> 성별 </option>
		      <option value = "male"> 남성 </option>
		      <option value = "female"> 여성 </option>
		      <option value = "notSelect"> 선택안함 </option>
		</select>
		
		<p class = "user_birthday_title">생년월일</p>
		<input type = "text" placeholder = "년(4자)" id = "user_birthday_year" class = "user_birthday_year" name = "user_birthday_year" maxlength = "4" onblur = "userBirthday()"/>
		<select id = "user_birthday_month" name = 'user_birthday_month' class = "user_birthday_month" onblur = "userBirthday()">
			<option value = "default"> 월 </option>
		   	<option value = "january"> 1 </option>
		   	<option value = "february"> 2 </option>
		   	<option value = "march"> 3 </option>
		   	<option value = "april"> 4 </option>
		   	<option value = "may"> 5 </option>
		   	<option value = "june"> 6 </option>
		   	<option value = "july"> 7 </option>
		   	<option value = "august"> 8 </option>
		   	<option value = "september"> 9 </option>
		   	<option value = "october"> 10 </option>
		   	<option value = "november"> 11 </option>
		   	<option value = "december"> 12 </option>
	   	</select>
	   	<input type = "text" placeholder = "일" id = "user_birthday_day" class = "user_birthday_day" name = "user_birthday_day" onblur = "userBirthday()" maxlength = "2"/>
		<div class = "user_birthday_check"></div>
		
		<p class = "user_email_title">이메일</p>
		<input type = "email" id = "user_email" class = "user_email" name = "user_email"/>
		
		<p class = "user_phone_title">휴대전화</p>
		<input type = "tel" id = "user_phone" class = "user_phone" name = "user_phone" placeholder = "-없이 입력하세요." onblur = "minusCut(this)"/>
		<div class = "user_birthday_phone"></div>
		
		<p>
			<input type = "submit" id = "user_signUp" class = "user_signUp"  name = "user_signUp" value = "회원가입">
		</p>
	</section>
	
	<footer class = "floorBar">	
		<div class = "togetherPeopleLeft">
			Together People<br>사람들과 함께함으로써 사람을 얻는 곳
		</div>
		<div class = "togetherPeopleRight">
			경상북도 경산시 진량읍 대구대로 299-31 TEL 010-2098-6362(대표번호, MSG)<br>
			Copyright(c) 2021 Min Sung Graphic All right Reserved.
		</div>
	</footer>
</form>
</body>
</html>