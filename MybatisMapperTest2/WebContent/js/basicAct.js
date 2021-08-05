/**
 * 
 */
function openNav() {
		document.getElementById('mysidenav').style.width = '300px';
	}
	function closeNav() {
		document.getElementById('mysidenav').style.width = '0';
	}
	function showPopup(hasFilter) {
		const popup = document.querySelector('#popup');
	  
	  if (hasFilter) {
	  	popup.classList.add('has-filter');
	  } else {
	  	popup.classList.remove('has-filter');
	  }
	  
	  popup.classList.remove('hide');
	}
	function closePopup() {
		const popup = document.querySelector('#popup');
	  popup.classList.add('hide');
	}
	function login_before_popup() {
		alert("로그인 후 이용해주세요.");	
	}
	function login_after_popup() {
		var popupWindow = "";
		var fr = document.getElementById("popupForm");
		
		var url = "popup";
        var name = "popup test";
        var option = "width = 450, height = 800, top = 100, left = 200, location = no, resizable = no";
        
        popupWindow = window.open("", name, option);
        popupWindow.focus();
        
        fr.action = url;
        fr.method = "post";
        fr.target = name;
        fr.submit();
        fr.target = "_self";
	}