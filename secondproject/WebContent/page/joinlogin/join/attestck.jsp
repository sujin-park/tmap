<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.userdto.UserDto"%>
    <%
    UserDto userDto = (UserDto) session.getAttribute("attestinfo");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
$()document.ready(function() {
	$.ajax({
		type : "post",
		url : "/secondproject/joinlogin",
		data : {'act' : 'lastcheck', 'user_id' : '<%=userDto.getUser_id()%>', 'email' : '<%=userDto.getEmail()%>', 'type' : '<%=userDto.getType()%>'},
		datatype : '??', //뭐라 적어야하노
		success : lastcheck
	})

});

function lastcheck() {
	if(){ //3가지 다 맞으면 
		$("#joinokmodal").modal("show"); //id가 joinok인 모달창 띄우기
	} else {
		$("#joinfailmodal").modal("show"); //id가 joinfail인 모달 띄우기
	}
}
</script>
</head>
<body>

</body>
</html>