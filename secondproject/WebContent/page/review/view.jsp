<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ReviewDto reviewDto = (ReviewDto) request.getAttribute("reviewDto");
if (reviewDto != null) {
%>

	<%=reviewDto.getTitle()%>
	<%=reviewDto.getContent()%>
	<%=reviewDto.getScore()%>
	<%=reviewDto.getImg()%>
	<%=reviewDto.getUpdateDate()%>

<% } %>