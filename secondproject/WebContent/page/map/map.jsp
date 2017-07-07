<%@page import="com.secondproject.map.model.FollowCategoryUserDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.secondproject.map.model.FollowCategoryDto"%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>
<% ArrayList<FollowCategoryDto> followList = (ArrayList<FollowCategoryDto>) request.getAttribute("followList");%>


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
					<option value="">메뉴</option>
					<option value="1">한식</option>
					<option value="2">중식</option>
					<option value="3">일식</option>
					<option value="4">양식</option>
				</select>
			</div>
		</div>
		
		<%
		if (followList != null) {
		%>
		<div class="row favorite-container">
			<div class="col-xs-12">
				<div class="panel panel-default favorite">
					<div class="panel-heading">팔로우</div>
					<div class="panel-body">
						<%
						int i = 0;
						for (FollowCategoryDto cate : followList) {
							ArrayList<FollowCategoryUserDto> userlist = cate.getCategoryUserList();
							int followUserCnt = userlist.size();
						%>
							<div class="panel panel-default favorite-item">
								<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample<%=i%>" <%=(followUserCnt == 0 ? "onclick=\"alert('등록된 유저가 없습니다.')\"" : "") %> >
									<input type="checkbox" name="" id="" />
									<span><%=cate.getCategoryName()%></span>
								</div>
								<%
								if (followUserCnt > 0) {
								%>
								<div class="collapse panel-collapse" id="collapseExample<%=i%>"  >
									<ul class="list-group">
										<%
										for (FollowCategoryUserDto userDto : userlist) {
										%>
										<li class="list-group-item"><div class="checkbox">
											<label>
												<input type="checkbox" class="followUserId" value="<%=userDto.getUserId()%>">
												<h5><%=userDto.getUserEmail()%></h5>
												<span><%=userDto.getAlias() %></span>
											</label>
										</li>
										<%
										}
										%>
									</ul>
								</div>
								<%
								}
								%>
							</div>
						<%
							i++;
						}
						%>
					</div>
				</div>
			</div>
		</div><!-- favorite-container -->
		<%
		}
		%>

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
			<div class="col-xs-12 col-md-6 pull-right">
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