<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page import="com.secondproject.shop.model.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%
	ShopDto shopDto = (ShopDto) request.getAttribute("shopDto");
%>

<div class="page-container">
	<div class="container">
		<div class="row">
			<%=shopDto.getCategoryTitle()%>
			<%=shopDto.getTitle()%>
			<%=shopDto.getTel()%>
			<%=shopDto.getScore()%>
			<%=shopDto.getBusinessTime()%>
			<%=shopDto.getDetail()%>
			<%=shopDto.getAddress()%>
			
			<ul>
				<li><button class="btn btn-default">器判府轰</button></li>
				<li><button class="btn btn-default">TMAP 府轰</button></li>
				<li><a href="<%=ContextPath.root%>/review?act=writeForm&shopId=<%=shopDto.getShopId()%>">府轰累己</a></li>
			</ul>
		</div>
	</div>
</div>

