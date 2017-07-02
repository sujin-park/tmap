<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String contentPath = (String) request.getAttribute("contentPath");
	String titleTagValue = (String) request.getAttribute("titleTagValue");
	String addHeadPath = (String) request.getAttribute("addHeadPath");
	String addBottomPath = (String) request.getAttribute("addBottomPath");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title><%=titleTagValue%></title>
	<jsp:include page="/template/main/include/head.jsp"></jsp:include>
	<% if (addHeadPath != null) { %>
		<jsp:include page="<%=addHeadPath%>"></jsp:include>
	<% } %>
</head>
<body>
	<jsp:include page="/template/main/include/header.jsp"></jsp:include>
	<jsp:include page="<%=contentPath%>"></jsp:include>
	<jsp:include page="/template/main/include/footer.jsp"></jsp:include>
	<jsp:include page="/template/main/include/bottom.jsp"></jsp:include>
	<% if (addBottomPath != null) { %>
		<jsp:include page="<%=addBottomPath%>"></jsp:include>
	<% } %>
</body>
</html>