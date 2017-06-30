<%@page import="com.secondproject.util.pagination.Pagination"%>
<%@page import="com.secondproject.util.Params"%>
<%@page import="com.secondproject.review.model.ReviewListDto"%>
<%@page import="com.secondproject.review.model.ReviewDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page import="com.secondproject.shop.model.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	Pagination pagination = (Pagination) request.getAttribute("pagination");
	Params params = (Params) request.getAttribute("params");
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
				<h3><%=shopDto.getTitle()%>
					<span class="badge"><%=shopDto.getScore()%></span>
				</h3>
				<ul class="list-group">
					<li class="list-group-item">주소 : <%=shopDto.getAddress()%></li>
					<li class="list-group-item">전화번호 : <%=shopDto.getTel()%></li>
					<%
						if (shopDto.getBusinessTime() != null) {
					%>
					<li class="list-group-item">영업시간 : <%=shopDto.getBusinessTime()%></li>
					<%
						}
					%>
					<%
						if (shopDto.getDetail() != null) {
					%>
					<li class="list-group-item">정보 : <%=shopDto.getDetail()%></li>
					<%
						}
					%>
				</ul>

			</div>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<ul>
					<li><button class="btn btn-default">포털리뷰</button></li>
					<li><button class="btn btn-default">TMAP 리뷰</button></li>
					<li><a
						href="<%=ContextPath.root%>/review?act=writeForm&shopId=<%=shopDto.getShopId()%>">리뷰작성</a></li>
				</ul>
			</div>
		</div>

		<div class="row">
			<%
				for (ReviewListDto reviewListDto : reviewList) {
			%>
			<div class="col-sm-6 col-md-4 ">
				<div class="thumbnail">
					<img src="..." alt="...">
					<div class="caption">
						<h3><a href="<%=ContextPath.root%>/review?act=view&reviewId=<%=reviewListDto.getReviewId()%>"><%=reviewListDto.getTitle()%></a></h3>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a>
							<a href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>

		<div class="row">
			<div class="col-xs-6 col-xs-offset-4">
				<%=pagination.getHtml()%>
			</div>
		</div>
	</div>
</div>

