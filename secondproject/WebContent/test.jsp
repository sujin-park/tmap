<%@page import="com.secondproject.util.Encoding"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=ContextPath.root%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=ContextPath.root%>/assets/css/bootstrap-theme.min.css" />
</head>
<body>

<%
String aaa = new String(request.getParameter("word").getBytes("ISO-8859-1"), "UTF-8");
String aaa2 = request.getParameter("word");
System.out.println(aaa);
System.out.println("zzz = " + aaa2);
%>

	<form action="" id="commonBoardSearchForm">
		<input type="hidden" name="key" />
		<input type="hidden" name="orderKey" />
		<input type="hidden" name="orderValue" />
		
		<div class="input-group">
			<div class="input-group-btn">
				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
					<span id="commonBoardSearchFormKeyView">리뷰명</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="javascript:changeCommonBoardSearchKey('리뷰명', '한글');">리뷰명</a></li>
					<li><a href="javascript:changeCommonBoardSearchKey('회원메일', 'ccc');">회원메일</a></li>
				</ul>
			</div>
			<input type="text" name="word" class="form-control" value="<%=aaa%>">
			<span class="input-group-btn">
				<button class="btn btn-default" type="submit">검색</button>
			</span>
		</div>
	</form>


	<script src="<%=ContextPath.root%>/assets/js/jquery-3.2.1.min.js"></script>
	<script src="<%=ContextPath.root%>/assets/js/bootstrap.min.js"></script>
</body>
</html>