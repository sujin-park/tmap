<%@page import="com.secondproject.util.pagination.Pagination"%>
<%@page import="com.secondproject.review.model.ReviewListDto"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page import="com.secondproject.shop.model.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String pagination = (String) request.getAttribute("pagination");
	String searchForm = (String) request.getAttribute("searchForm");
	ShopDto shopDto = (ShopDto) request.getAttribute("shopDto");
	ArrayList<ReviewListDto> reviewList = (ArrayList<ReviewListDto>) request.getAttribute("reviewList");
%>

<div class="page-container">
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

		<div class="row review-list-container">
			<%
				int i = 0;
				String grid2;
				String grid3;
				for (ReviewListDto reviewListDto : reviewList) {
					grid2 = (i % 2 == 0) ? "grid-2" : "";
					grid3 = (i % 3 == 0) ? "grid-3" : "";
			%>
			<div class="review col-sm-6 col-md-4 <%=grid2%> <%=grid3%>">
				<div class="thumbnail">
					<%
					if (reviewListDto.getImg() != null && reviewListDto.getImg().trim().isEmpty() == false) {
					%>
						<a href="<%=ContextPath.root + "/review?act=view&reviewId=" + reviewListDto.getReviewId()%>">
							<img src="<%=ContextPath.root + reviewListDto.getImg()%>" class="img-responsive img-rounded">
						</a>
					<%
					}
					%>

					<div class="caption">
						<h4><a href="<%=ContextPath.root + "/review?act=view&reviewId=" + reviewListDto.getReviewId()%>"><%=reviewListDto.getTitle()%></a></h4>
						<div class="info-container">
							<a href="<%=ContextPath.root + "/myreview?act=yourreview&followUserId=" + reviewListDto.getUserId()%>"><%=reviewListDto.getUserEmail()%></a>
							<div class="clearfix">
								<span class="pull-right"><%=reviewListDto.getRegDate()%></span>
								<div class="good-bad-container pull-left">
									<span class="label label-warning">좋아요 <%=reviewListDto.getGoodCount()%></span>
									<span class="label label-warning">싫어요 <%=reviewListDto.getBadCount()%></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%		
					i++;
				}
			%>
		</div>

		<% if (pagination != null && pagination.isEmpty() == false) { %>
		<div class="row">
			<div class="col-xs-12">
				<%=pagination%>
			</div>
		</div>
		<% } %>
		
		<% if (searchForm != null && searchForm.isEmpty() == false) { %>
		<div class="row">
			<div class="col-xs-12 col-md-5 col-md-offset-3">
				<%=searchForm%>
			</div>
			<div class="col-xs-12 col-md-1 text-center"><a href="<%=ContextPath.root%>/review?act=writeForm&shopId=<%=shopDto.getShopId()%>" class="btn btn-danger">리뷰작성</a></div>
		</div>
		<% } %>
	</div>
</div>
