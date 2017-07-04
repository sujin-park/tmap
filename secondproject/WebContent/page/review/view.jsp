<%@page import="com.secondproject.constant.ContextPath"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ReviewDto reviewDto = (ReviewDto) request.getAttribute("reviewDto");
if (reviewDto != null) {
%>
<div class="page-container review-view-page">

	<div class="container">
	
		<div class="row">
			<div class="col-xs-12">
				<h1><%=reviewDto.getTitle()%></h1>
				<div class="info-container">
					<span class="label label-warning"><%=reviewDto.getScore()%>Á¡</span>
					<span><%=reviewDto.getUpdateDate()%></span>
				</div>
			</div>
		</div>
		
		<div class="row review-content">
			<div class="col-xs-12">
				<%=reviewDto.getContent()%>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<a href="<%=ContextPath.root%>/shop?act=view&shopId=<%=reviewDto.getShopId()%>" class="btn btn-default">¸ñ·Ï</a>
			</div>
		</div>
	</div>
	
</div>
<% } %>