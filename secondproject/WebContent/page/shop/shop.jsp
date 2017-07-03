<%@page import="com.secondproject.util.pagination.Pagination"%>
<%@page import="com.secondproject.review.model.ReviewListDto"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page import="com.secondproject.shop.model.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	Pagination pagination = (Pagination) request.getAttribute("pagination");
	ShopDto shopDto = (ShopDto) request.getAttribute("shopDto");
	ArrayList<ReviewListDto> reviewList = (ArrayList<ReviewListDto>) request.getAttribute("reviewList");
%>

<div class="page-container">
	<div class="container">

		<div class="row">
			<div class="col-xs-12 col-md-3">
				<img src="<%=ContextPath.root%>/upload/test/test.png"
					class="img-responsive" />
			</div>
			<div class="col-md-9">
			
				<span class="label label-default"><%=shopDto.getCategoryTitle()%></span>
				<h3>
					<%=shopDto.getTitle()%>
					<span class="badge"><%=shopDto.getScore()%></span>
					<a href="<%=ContextPath.root%>/review?act=writeForm&shopId=<%=shopDto.getShopId()%>">리뷰작성</a>
				</h3>
				<ul class="list-group">
					<li class="list-group-item">주소 : <%=shopDto.getAddress()%></li>
					<li class="list-group-item">전화번호 : <%=shopDto.getTel()%></li>
					
					<% if (shopDto.getBusinessTime() != null) { %>
					<li class="list-group-item">영업시간 : <%=shopDto.getBusinessTime()%></li>
					<% } %>
					
					<% if (shopDto.getDetail() != null) { %>
					<li class="list-group-item">정보 : <%=shopDto.getDetail()%></li>
					<% } %>
				</ul>

			</div>
		</div>

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
					<a href="<%=ContextPath.root + "/review?act=view&reviewId=" + reviewListDto.getReviewId()%>">
						<img src="<%=ContextPath.root + reviewListDto.getImg()%>">
					</a>
					<div class="caption">
						<h4><a href="<%=ContextPath.root + "/review?act=view&reviewId=" + reviewListDto.getReviewId()%>"><%=reviewListDto.getTitle()%></a></h4>
						<div class="info-container">
							<a href="javascript:alert('유저정보  + 팔로우 모달');"><%=reviewListDto.getUserEmail()%></a>
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

		<div class="row">
			<div class="col-xs-12">
				<%=pagination.getHtml()%>
			</div>
		</div>
	</div>
</div>
