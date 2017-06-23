var httpRequest;
function getXMLHttpRequest() {
		if (window.ActiveXObject) { // Internet Explorer라면
			try {
				return new ActiveXObject("Msxml2.XMLHTTP"); // 7이상
			} catch (e1) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP"); // 7이하
				} catch (e2) {
					alert("지원하지않는 브라우저입니다.");
					return null;
				}

			}
		} else if (window.XMLHttpRequest) { // chrome, safari, firefox등등
			return new XMLHttpRequest();
		} else { // HttpRequest를 지원하지 않는 브라우저
			alert("지원하지않는 브라우저입니다.");
			return null;
		}
	}

	function sendRequest(url, param, callback, method) {
		httpRequest = getXMLHttpRequest();
		
		var httpMethod = method ? method : "GET"; // method가 null인지 아닌지
		if (httpMethod != "GET" && httpMethod != "POST") {
			httpMethod = "GET";
		}
		
		var httpParam = (param == null || param == "") ? null : param;
		var httpUrl = url;
		if(httpMethod == "GET" && httpParam != null) {
			httpUrl = httpUrl + "?" + httpParam;
			
		}
		
		
		httpRequest.onreadystatechange = callback; // starttime은 call back함수
		httpRequest.open(httpMethod, httpUrl, true); // get, url, 동기화할건지 비동기화 할건지 비동기화하면 true
		httpRequest.send(httpMethod == "POST" ? httpParam : null); // POST방식일때만 httpParam을 보낸다
	} // callback함수 이름, get/post, url만 바꾸면 됨 
	
	
	
	
	
	
	
	