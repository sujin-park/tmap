<%@page import="com.secondproject.shop.model.ShopCategoryDto"%>
<%@page import="com.secondproject.map.model.FollowCategoryUserDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.map.model.FollowCategoryDto"%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>
<%
ArrayList<ShopCategoryDto> shopCategoryList = (ArrayList<ShopCategoryDto>) request.getAttribute("shopCategoryList");
%>


<div class="search-detail-controll-container">
	<div class="search-detail-controll">
		
		<div class="row">
			<div class="col-xs-12 search-detail-controll-close-container">
				<i class="fa fa-times" aria-hidden="true" id="search_detail_controll_close_btn"></i>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<select class="form-control" id="search_menu">
					<option value="0">전체카테고리</option>
					<%
					if (shopCategoryList.size() > 0) {
						for(ShopCategoryDto shopCategoryDto : shopCategoryList)  {
					%>
					<option value="<%=shopCategoryDto.getCategoryId()%>"><%=shopCategoryDto.getCategoryTitle()%></option>
					<%
						}
					}
					%>
				</select>
			</div>
		</div>
		
		<div class="row favorite-container">
			<div class="col-xs-12">
				<div class="panel panel-default favorite">
					<div class="panel-heading">팔로우</div>
					<div class="panel-body" id="follow-data-insert">

					</div>
				</div>
			</div>
		</div><!-- favorite-container -->

		<div class="row">
			<div class="col-xs-12">
				<button class="btn btn-danger" type="button" id="search-detail-controll-submit" data-searching-text="검색중..." autocomplete="off">검색</button>
			</div>
		</div>

	</div>
</div>

<div class="search-controll-container">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-md-5 col-lg-4 pull-right">
				<div class="search-controll">
					<div class="row">
						<div class="col-xs-6">
							<button class="btn btn-primary" type="button" id="modal_add_shop_btn">매장등록</button>
						</div>
						<div class="col-xs-6">
							<button class="btn btn-primary" type="button" id="search_detail_controll_btn">검색</button>
						</div>
					</div>
					<div class="input-group searchMapByLocation">
						<input type="text" class="form-control" placeholder="지역명" id="addressValue"> 
						<span class="input-group-btn">
							<button class="btn btn-primary" type="button" id="search_map_by_location_btn">지역검색</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="map-container">
	<div id="map"></div>
</div>

<div class="search-list-container-mobile">
	<div class="search-list"></div>
</div>

<div class="search-list-container">
	<div class="search-list">
		<span>로오딩..</span>
	</div>
</div>

<jsp:include page="addShopForm.jsp"></jsp:include>