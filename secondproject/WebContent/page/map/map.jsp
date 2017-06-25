<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>

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
		
		<div class="row favorite-container">
			<div class="col-xs-12">
			
				<div class="panel panel-default favorite">
					<div class="panel-heading">팔로우</div>
					<div class="panel-body">
						<div class="panel panel-default favorite-item">
							<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample1">group1</div>
							<div class="collapse panel-collapse" id="collapseExample1">
								<ul class="list-group">
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default favorite-item">
							<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample2">group2</div>
							<div class="collapse panel-collapse" id="collapseExample2">
								<ul class="list-group">
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default favorite-item">
							<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample5">group2</div>
							<div class="collapse panel-collapse" id="collapseExample5">
								<ul class="list-group">
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default favorite-item">
							<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample3">group2</div>
							<div class="collapse panel-collapse" id="collapseExample3">
								<ul class="list-group">
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default favorite-item">
							<div class="panel-heading" data-toggle="collapse" data-target="#collapseExample4">group2</div>
							<div class="collapse panel-collapse" id="collapseExample4">
								<ul class="list-group">
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
									<li class="list-group-item"><div class="checkbox"><label><input type="checkbox" value=""> nimrh1k (이형규)</label></div></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div><!-- favorite-container -->

		<div class="row">
			<div class="col-xs-12">
				<button class="btn btn-default btn-sm" type="button" id="search-detail-controll-submit" data-searching-text="검색중..." autocomplete="off">검색!!!</button>
			</div>
		</div>
		
	</div>
</div>

<div class="search-controll-container">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="search-controll">
					<!-- href="<%=ContextPath.root%>/shop?act=addShopForm" target="_blank" -->
					<button class="btn btn-sm btn-primary" id="modal_add_shop_btn">매장등록</button>
					<button class="btn btn-sm btn-primary" type="button" id="search_detail_controll_btn">검색</button>
					<span class="label label-danger">현재 검색조건</span> [전체메뉴] [전체유저]
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
	<h3>List...디자이너가피료..</h3>
	<div class="search-list">
		<span>로오딩..</span>
	</div>
</div>

<jsp:include page="addShopForm.jsp"></jsp:include>