<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.userdto.UserDto"%>
    
    <%
    UserDto userDto = (UserDto) session.getAttribute("attestinfo");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="sendmail.jsp" method="post">
			<table>
				<tr>
					<th colspan="2">Email 인증 확인</th>
				</tr>
				<tr>
					<td>from</td>
					<td><input type="text" name="from" value="cjsmc@naver.com"/></td>
				</tr>
				<tr>
					<td>to</td>
					<td><input type="text" name="to" /><%=userDto.getEmail() %></td>
				</tr>
				<tr>
					<td>subject</td>
					<td><input type="text" name="subject" value="Tmap에서 보낸 이메일입니다."/></td>
				</tr>
				<tr>
					<td>content</td>
					<td>
						<textarea name="content" style="width: 170px; height: 200px;">
							<center>
							<%=userDto.getEmail() %>님 아래 버튼을 클릭하면 이메일 인증이 완료됩니다.
							<button onclick="javascript:confirmmove();">인증하기</button>
							</center>
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input
						type="submit" value="Transmission" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
	
	
});

function confirmmove() {
	document.location.href="http://localhost/secondproject/page/joinlogin/join/attestck.jsp";
	
}
</script>
