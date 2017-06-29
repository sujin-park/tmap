<%@page import="com.secondproject.review.model.ReviewListDto"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page import="com.secondproject.shop.model.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%
	ShopDto shopDto = (ShopDto) request.getAttribute("shopDto");
	ArrayList<ReviewListDto> reviewList = (ArrayList<ReviewListDto>) request.getAttribute("reviewList");
%>

<div class="page-container">
	<div class="container">
	
		<div class="row">
			<div class="col-xs-12 col-md-3">
				<img src="<%=ContextPath.root%>/upload/test/test.png" class="img-responsive" />
			</div>
			<div class="col-md-9">
				<span class="label label-default"><%=shopDto.getCategoryTitle()%></span>
				<h3><%=shopDto.getTitle()%> <span class="badge"><%=shopDto.getScore()%></span></h3>
				<ul class="list-group">
					<li class="list-group-item">�ּ� : <%=shopDto.getAddress()%></li>
					<li class="list-group-item">��ȭ��ȣ : <%=shopDto.getTel()%></li>
					<% if (shopDto.getBusinessTime() != null) { %>
						<li class="list-group-item">�����ð� : <%=shopDto.getBusinessTime()%></li>
					<% } %>
					<% if (shopDto.getDetail() != null) { %>
						<li class="list-group-item">���� : <%=shopDto.getDetail()%></li>
					<% } %>
				</ul>
				
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<ul>
					<li><button class="btn btn-default">���и���</button></li>
					<li><button class="btn btn-default">TMAP ����</button></li>
					<li><a href="<%=ContextPath.root%>/review?act=writeForm&shopId=<%=shopDto.getShopId()%>">�����ۼ�</a></li>
				</ul>
				<ul>
					<% for (ReviewListDto reviewListDto :reviewList) { %>
						<li><%=reviewListDto.getTitle() %></li>
					<% } %>
				</ul>
			</div>
		</div>
	</div>
</div>

