<%@page import="com.secondproject.constant.ContextPath"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ReviewDto reviewDto = (ReviewDto) request.getAttribute("reviewDto");
if (reviewDto != null) {
%>
<div class="page-container">

	<h1><%=reviewDto.getTitle()%></h1>
	<%=reviewDto.getScore()%>
	<div class="row">
		<div class="col-md-12">
			<%=reviewDto.getContent()%>
		</div>
	</div>
	
	
	
	
	<% if (reviewDto.getImg() != null) { %>
		<img src="<%=ContextPath.root + reviewDto.getImg()%>" />
	<% } %>
	
	<%=reviewDto.getUpdateDate()%>
</div>
<% } %>