var view;

function logincheck(){
	if(document.getElementById("email").value == ""){
		alert("이메일을 입력해주세요.");
		return;
	} else if (document.getElementById("password").value == ""){
		alert("비밀번호를 입력해주세요.");
		return; 
	} else { 
		document.loginform.action = "/secondproject/joinlogin"
		document.loginform.submit();
	}
}

function attest() {
	if (document.getElementById("joinEmail").value == "") {
		alert("이메일을 입력해주세요.");
		return;
	} else if (document.getElementById("joinPassword").value == "") {
		alert("비밀번호를 입력해주세요.");
		return;
	} else if (document.getElementById("joinPassword").value != document.getElementById("password_check").value) {
		alert("비밀번호를 확인해주세요.");
		return;
	} else if (document.getElementById("gender").value == "") {
		alert("성별를 입력해주세요.");
		return;
	} else if (document.getElementById("age").value == "") {
		alert("나이를 입력해주세요.");
		return;
	} else {
		document.joinform.action = CONTEXT_PATH + "/secondproject/joinlogin"
		document.joinform.submit();
	}
}

function idcheck() {
	view = document.getElementById("idresult");
	var idck = document.getElementById("joinEmail").value;
	console.log(idck.match("@"));
	if(idck.match("@") == null){
		view.innerHTML="<font color='RED'>이메일 형식을 갖추어야합니다.</font>"
	} else {
		var param ="act=idcheck&email=" + encodeURIComponent(idck);
		sendRequest(CONTEXT_PATH + "/joinlogin", param, idresult, "GET");
	}
}

function idresult() {
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			var txt = httpRequest.responseText;
			view.innerHTML = txt; 
		} else {
			alert("문제발생 : " + httpRequest.status);
		}
	}
}

function pwcheck() {
	view = document.getElementById("pw_check");
	var pw = document.getElementById("joinPassword").value;
	var pwck = document.getElementById("password_check").value;
	if(pw != pwck){
		view.innerHTML="<font color='RED'>비밀번호가 일치하지 않습니다.</font>"
	} else {
		view.innerHTML="<font color='BLUE'>비밀번호가 일치합니다.</font>"
	}
}

function loginmove() {
	$("#loginmodal").modal("show");
}

function joinmove() {
	$("#joinmodal").modal("show");
}

function logoutmove() {
	document.location.href = CONTEXT_PATH + "/joinlogin?act=logout";
}