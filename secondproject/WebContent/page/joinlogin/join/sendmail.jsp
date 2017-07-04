<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="javax.mail.*"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="com.secondproject.joinlogin.email.SMTPAuthenticatior"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("EUC-KR");

	String from = "Tmap@kitri.com";
	String to = request.getParameter("email");
	String subject = "Tmap에서 보낸 인증 메일입니다.";
	String content = to + "님  아래 버튼을 클릭하면 인증이 완료됩니다.";
	String checkkey = request.getParameter("");
 //TODO content 안에 인증 버튼 삽입 완료하기 %>
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
					<td><input type="text" name="to" /></td>
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
							님 아래 버튼을 클릭하면 이메일 인증이 완료됩니다.
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
<%
	// 입력값 받음

	Properties p = new Properties(); // 정보를 담을 객체

	p.put("mail.smtp.host", "smtp.naver.com"); // 네이버 SMTP

	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");
	// SMTP 서버에 접속하기 위한 정보들

	try {
		Authenticator auth = new SMTPAuthenticatior();
		Session ses = Session.getInstance(p, auth);

		ses.setDebug(true);

		MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		msg.setSubject(subject); // 제목

		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr); // 보내는 사람

		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람

		msg.setContent(content, "text/html;charset=EUC-KR"); // 내용과 인코딩

		Transport.send(msg); // 전송
	} catch (Exception e) {
		e.printStackTrace();
		out.println("<script>alert(메일 발송이 실패하였습니다. 다시 시도해주세요.');history.back();</script>");
		// 오류 발생시 뒤로 돌아가도록
		return;
	}

	out.println(
			"<script>alert('메일이 발송되었습니다. 이메일을 확인해주세요. 유효 시간은 10분입니다.');location.href='sendmail.jsp?act=lastcheck&email=" + to + "';</script>");
	// 성공 시
%>
