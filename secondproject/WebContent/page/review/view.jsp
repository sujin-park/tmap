<%@page import="java.util.HashMap"%>
<%@page import="com.secondproject.shop.model.ShopDto"%>
<%@page import="com.secondproject.userdto.UserDto"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ReviewDto reviewDto = (ReviewDto) request.getAttribute("reviewDto");
UserDto userDto = (UserDto) request.getAttribute("userDto");
ShopDto shopDto = (ShopDto) request.getAttribute("shopDto");
HashMap<String, String> linkMap = (HashMap<String, String>) request.getAttribute("linkMap");
%>

<div class="page-container review-view-page">

	<div class="container">
	
		<div class="row">
			<%
			if (shopDto.getImg() != null && shopDto.getImg().trim().isEmpty() == false) {
			%>
				<div class="col-xs-12 col-md-4 shopImg">
					<img src="<%=ContextPath.root%><%=shopDto.getImg()%>" class="img-responsive img-rounded" />
				</div>
			<%
			}
			%>
			
			<div class="col-xs-12 col-md-8">
				<div class="table-responsive">
					<table class="table shopInfoContainer">
						<tr>
							<th colspan="2">
								<span class="shopTitle"><%=shopDto.getTitle()%></span>&nbsp;&nbsp;
								<span class="label label-warning categoryTitle"><%=shopDto.getCategoryTitle()%></span>&nbsp;
								<span class="label label-danger score">평점&nbsp;&nbsp;<%=shopDto.getScore()%></span>
							</th>
						</tr>
						<tr>
							<td>주소</td>
							<td><%=shopDto.getAddress()%></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><%=shopDto.getTel()%></td>
						</tr>
						<tr>
							<td>영업시간</td>
							<td><%=shopDto.getBusinessTime()%></td>
						</tr>
						<tr>
							<td>정보</td>
							<td><%=shopDto.getDetail()%></td>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
		
		<div class="hr"></div>
		
		<div class="row">
			<div class="col-xs-12">
				<h2><%=reviewDto.getTitle()%></h2>
				<div class="info-container">
					<span class="label label-warning"><%=reviewDto.getScore()%>점</span>
					<a href=""><%=userDto.getEmail()%></a>
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
				<%
				for (String key : linkMap.keySet()) {
				%>
					<%=linkMap.get(key)%>
				<%
				}
				%>
			</div>
		</div>
	</div>
	
</div>
