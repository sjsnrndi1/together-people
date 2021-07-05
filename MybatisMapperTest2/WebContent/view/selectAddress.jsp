<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 검색</title>
<script>
	function checkSi(select_si) {
		var selected_index = select_si.selectedIndex;
		var selected_value = select_si.options[selected_index].value;
		document.getElementById("address_gu_suseong").style.display = 'none';
		document.getElementById("address_gu_busan").style.display = 'none';
		document.getElementById("address_gu_seoul").style.display = 'none';
		document.getElementById("address_ro_suseong1").style.display = 'none';
		document.getElementById("address_ro_suseong2").style.display = 'none';
		document.getElementById("address_ro_suseong3").style.display = 'none';
		document.getElementById("address_ro_busan1").style.display = 'none';
		document.getElementById("address_ro_busan2").style.display = 'none';
		document.getElementById("address_ro_busan3").style.display = 'none';
		document.getElementById("address_ro_seoul1").style.display = 'none';
		document.getElementById("address_ro_seoul2").style.display = 'none';
		document.getElementById("address_ro_seoul3").style.display = 'none';
		
		if(selected_value == "대구광역시") {
			document.getElementById("address_gu_suseong").style.display = 'block';
		} else if(selected_value == "부산광역시") {
			document.getElementById("address_gu_busan").style.display = 'block';
		} else {
			document.getElementById("address_gu_seoul").style.display = 'block';
		}
		
		opener.document.getElementById("user_postNumber").value = selected_value;
	}
	function checkGu(select_gu) {
		var selected_index = select_gu.selectedIndex;
		var selected_value = select_gu.options[selected_index].value;
		document.getElementById("address_ro_suseong1").style.display = 'none';
		document.getElementById("address_ro_suseong2").style.display = 'none';
		document.getElementById("address_ro_suseong3").style.display = 'none';
		document.getElementById("address_ro_busan1").style.display = 'none';
		document.getElementById("address_ro_busan2").style.display = 'none';
		document.getElementById("address_ro_busan3").style.display = 'none';
		document.getElementById("address_ro_seoul1").style.display = 'none';
		document.getElementById("address_ro_seoul2").style.display = 'none';
		document.getElementById("address_ro_seoul3").style.display = 'none';

		if(selected_value == "수성구") {
			document.getElementById("address_ro_suseong1").style.display = 'block';
		} else if(selected_value == "남구") {
			document.getElementById("address_ro_suseong2").style.display = 'block';
		} else if(selected_value == "북구"){
			document.getElementById("address_ro_suseong3").style.display = 'block';
		} else if(selected_value == "부산구"){
			document.getElementById("address_ro_busan1").style.display = 'block';
		} else if(selected_value == "남서구"){
			document.getElementById("address_ro_busan2").style.display = 'block';
		} else if(selected_value == "해구"){
			document.getElementById("address_ro_busan3").style.display = 'block';
		} else if(selected_value == "서울구"){
			document.getElementById("address_ro_seoul1").style.display = 'block';
		} else if(selected_value == "이서구"){
			document.getElementById("address_ro_seoul2").style.display = 'block';
		} else if(selected_value == "남산구"){
			document.getElementById("address_ro_seoul3").style.display = 'block';
		}
		
		opener.document.getElementById("user_address").value = selected_value;
	}
	function checkRo(select_ro) {
		var selected_index = select_ro.selectedIndex;
		var selected_value = select_ro.options[selected_index].value;
		opener.document.getElementById("user_detailAddress").value = selected_value;
	}
	function cancelAddress() {
		opener.document.getElementById("user_postNumber").value = "시";
		opener.document.getElementById("user_address").value = "구";
		opener.document.getElementById("user_detailAddress").value = "로";
		window.close();
	}
</script>
<style>
	.addressSelectArea {
		width : 100%;
		height : auto;
		margin : auto;
		float : left;
	}
	#address_si {
		width : 25%;
		height : auto;
		margin : 4%;
		float : left;
	}
	#address_gu_suseong, #address_gu_busan, #address_gu_seoul {
		width : 25%;
		height : auto;
		margin : 4%;
		float : left;
		display : none;
	}
	#address_ro_suseong1, #address_ro_suseong2, #address_ro_suseong3 {
		width : 25%;
		height : auto;
		margin : 4%;
		float : left;
		display : none;
	}
	#address_ro_busan1, #address_ro_busan2, #address_ro_busan3 {
		width : 25%;
		height : auto;
		margin : 4%;
		float : left;
		display : none;
	}
	#address_ro_seoul1, #address_ro_seoul2, #address_ro_seoul3 {
		width : 25%;
		height : auto;
		margin : 4%;
		float : left;
		display : none;
	}
	.addressTitle {
		text-align : center;
		font-size : 20px;
	}
</style>
</head>
<body>
<img alt = "title" src = "${togetherPeopleTitle}" style = "width : 100%; height : 100px;">
	<hr>
	<form action = "userRegist.jsp" method = "POST">
	<div class = "addressSelectArea">
		<p class = "addressTitle">주소</p>
			<select name = "address_si" id = "address_si" onchange = 'checkSi(this)'>
				<option value = "" selected></option>
				<option value = "대구광역시">대구광역시</option>
				<option value = "부산광역시">부산광역시</option>
				<option value = "서울특별시">서울특별시</option>
			</select>
			<select name = "address_gu" id = "address_gu_suseong" onchange = 'checkGu(this)'>
				<option value = "" selected></option>
				<option value = "수성구">수성구</option>
				<option value = "남구">남구</option>
				<option value = "북구">북구</option>
			</select>
			<select name = "address_gu" id = "address_gu_busan" onchange = 'checkGu(this)'>
				<option value = "" selected></option>
				<option value = "부산구">부산구</option>
				<option value = "남서구">남서구</option>
				<option value = "해구">해구</option>
			</select>
			<select name = "address_gu" id = "address_gu_seoul" onchange = 'checkGu(this)'>
				<option value = "" selected></option>
				<option value = "서울구">서울구</option>
				<option value = "이서구">이서구</option>
				<option value = "남산구">남산구</option>
			</select>
			<select name = "address_ro" id = "address_ro_suseong1" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "수성1로">수성1로</option>
				<option value = "수성2로">수성2로</option>
				<option value = "수성3로">수성3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_suseong2" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "남1로">남1로</option>
				<option value = "남2로">남2로</option>
				<option value = "남3로">남3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_suseong3" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "북1로">북1로</option>
				<option value = "북2로">북2로</option>
				<option value = "북3로">북3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_busan1" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "부산1로">부산1로</option>
				<option value = "부산2로">부산2로</option>
				<option value = "부산3로">부산3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_busan2" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "남서1로">남서1로</option>
				<option value = "남서2로">남서2로</option>
				<option value = "남서3로">남서3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_busan3" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "해1로">해1로</option>
				<option value = "해2로">해2로</option>
				<option value = "해3로">해3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_seoul1" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "서울1로">서울1로</option>
				<option value = "서울2로">서울2로</option>
				<option value = "서울3로">서울3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_seoul2" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "이서1로">이서1로</option>
				<option value = "이서2로">이서2로</option>
				<option value = "이서3로">이서3로</option>
			</select>
			<select name = "address_ro" id = "address_ro_seoul3" onchange = 'checkRo(this)'>
				<option value = "" selected></option>
				<option value = "남산1로">남산1로</option>
				<option value = "남산2로">남산2로</option>
				<option value = "남산3로">남산3로</option>
			</select>
	</div>
<hr>
	<div style = "text-align : center; width : 100%; height : auto;">
		<input type = "button" value = "등록" onclick = "window.close()"/>
		<input type = "button" value = "검색취소" onclick = "cancelAddress()"/>
		<!--  <a href = "#" onclick = "window.close()">검색취소</a> -->
	</div>
	</form>
</body>
</html>