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
String myGoodBad = (String) request.getAttribute("myGoodBad");
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
								<span class="label label-default categoryTitle"><%=shopDto.getCategoryTitle()%></span>&nbsp;
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
				<h3><%=reviewDto.getTitle()%> &nbsp;<span class="label label-danger"><%=reviewDto.getScore()%>점</span></h3>
				<div class="info-container">
					<a href="<%=ContextPath.root + "/myreview?act=yourreview&followUserId=" + reviewDto.getUserId()%>"><%=userDto.getEmail()%></a>
					 <span><%=reviewDto.getUpdateDate()%></span>
				</div>
			</div>
			<div class="col-xs-12 like-unlike-container">
				<button class="btn btn-sm <%=(myGoodBad.equals("good") ? "on" : "")%>" onclick="goodBad(<%=reviewDto.getReviewId()%>, 'good')"><i class="fa fa-thumbs-up" aria-hidden="true"></i> 좋아요 <span><%=reviewDto.getGood()%></span></button>&nbsp;
				<button class="btn btn-sm <%=(myGoodBad.equals("bad") ? "on" : "")%>" onclick="goodBad(<%=reviewDto.getReviewId()%>, 'bad')" ><i class="fa fa-thumbs-down" aria-hidden="true"></i> 싫어요 <span><%=reviewDto.getBad()%></span></button>
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
					<%=linkMap.get(key)%>&nbsp;
				<%
				}
				%>
			</div>
		</div>
	</div>
	
</div>
