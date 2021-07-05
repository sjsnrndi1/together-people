<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스팅 등록</title>
<script>
	function postingCancel() {
		window.close();
	}
	function postingSuccess() {
		var content = document.getElementById("postingContent");
		if(content.value == ""){
			alert("내용을 입력하세요.");
		} else {
			opener.location.reload();
			window.close();
		}
	}
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
</script>
<style>
	.postingCc {
		
	}
	h4 {
		text-align : center;
	}
	#postingContent {
		width : 90%;
		height : auto;
		margin : 5%;
		resize : none;
	}
	.postingCc {
		text-align : center;
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
	<form action = "postingRegistForm" method = "POST">
	<img alt = "title" src = "${togetherPeopleTitle }" style = "width : 100%; height : 100px;">

<hr>
	
	<h4>포스팅 등록</h4>
	
	<input type = "hidden" id = "user_id" name = "user_id" value = "${userInfo.user_id }"/>
	<input type = "hidden" id = "user_name" name = "user_name" value = "${userInfo.user_name }"/>
	<textarea rows = "10" cols = "10" id = "postingContent" name = "postingContent" onKeyUp = "fnChkByte(this, '1000')" placeholder = "오늘의 일상을 공유해보아요~"></textarea><br>
	
	<span id = "byteInfo">0</span><span id = "byteInfo2">/1000byte</span><br>
	<input type = "submit" class = "postingCc" onclick = "postingSuccess()" value = "등록"/>
	
	<input type = "button" class = "postingCc" onclick = "postingCancel()" value = "취소"/>
	
	</form>
</body>
</html>