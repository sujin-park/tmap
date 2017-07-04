var view;
var httpRequest;

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
		document.joinform.action = CONTEXT_PATH + "/joinlogin"
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

function getXMLHttpRequest() {
	if (window.ActiveXObject) { // IE 라면
		try {
			return new ActiveXObject("Msxml2.XMLHTTP"); // IE 7이상
		} catch (e1) { // 자바스크립트도 익셉션 처리 가능 e만 써도 알아서
			try {
				return new ActiveXObject("Microsoft.XMLHTTP"); // IE 7 밑
			} catch (e2) { // 자바스크립트도 익셉션 처리 가능 e만 써도 알아서
				alert("지원하지 않는 브라우저입니다.");
				return null;
			}
		}
	} else if (window.XMLHttpRequest) { // IE가 아닌 나머지
		return new XMLHttpRequest(); // 이렇게 만들어주면 된다.
	} else { // XMLHttpRequest를 지원하지 않는 브라우저
		alert("지원하지 않는 브라우저입니다.");
		return null;
	}
}

function sendRequest(url, param, callback, method) { //4개가 변수니 받는걸로 설정
	httpRequest = getXMLHttpRequest(); // 브라우저마다 달라서 여기서 객체 생성
	
	var httpMethod = method ? method : "GET"; //스크립도 삼항연산자 가능
	if(httpMethod != "GET" && httpMethod != "POST") {
		httpMethod = "GET" //디폴트는 무조건 get이 되게끔
	} //메소드 타입 완성
	
	var httpParam = (param == null || param == "") ? null : param;
	var httpUrl = url;
	if(httpMethod == "GET" && httpParam != null) { //겟이면서 null이 아닌 경우
		httpUrl = httpUrl + "?" + httpParam;
	}
	
	httpRequest.onreadystatechange = callback; 
	httpRequest.open(httpMethod, httpUrl, "true"); // post가 아닌 경우 (이상하게 적는경우 포함) default는 get
	httpRequest.send(httpMethod == "POST" ? httpParam : null); // post방식에선 send에서 param 그대로 보내고 get이면 null로
}