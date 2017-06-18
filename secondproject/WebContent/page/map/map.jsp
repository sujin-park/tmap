<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<div class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Search</h4>
      </div>
      
      <div class="modal-body">
      
		<div class="row">
			<div class="col-xs-4">
				<select class="form-control" id="search_menu">
					<option value="">메뉴</option>
					<option value="1">한식</option>
					<option value="2">중식</option>
					<option value="3">일식</option>
					<option value="4">양식</option>
				</select>
			</div>
			<div class="col-xs-4">
				<select class="form-control" id="search_orderby">
					<option value="">정렬순서</option>
					<option value="score">평점순</option>
					<option value="distance">거리순</option>
				</select>
			</div>
			<div class="col-xs-4">
				<select class="form-control" id="search_where">
					<option value="">검색위치</option>
					<option value="myposition">내위치기준</option>
					<option value="currentmap">현재맵기준</option>
				</select>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-12 favorite-container">
				<div class="panel panel-default">
					<div class="panel-heading">북마크</div>
					<div class="panel-body mobile-scroll">
					
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
						
					</div>
				</div>
			</div>
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="search_submit">Save changes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="page-container">
	<div class="map-container">
		<div class="search-container">
			<div class="container-fluid">
				<div class="row">
					<button class="btn btn-sm btn-primary pull-left" type="button" id="test">TEST</button>
					<button class="btn btn-sm btn-primary pull-right" type="button" id="search_modal_open">검색</button>
				</div>
			</div>
		</div>
		<div id="map"></div>
		<div class="search-list-container">
			<div class="panel panel-default">
				<div class="panel-body">
				Basic panel example
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
				Basic panel example
				</div>
			</div>
		</div>
	</div>
</div>
