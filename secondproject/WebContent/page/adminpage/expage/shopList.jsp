<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.admin.model.*"
	import="com.secondproject.shop.model.*"%>

<%
List<ShopDto> list = (List<ShopDto>) request.getAttribute("exShopList");
%>
<section class="content page-top">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-left col-md-7">
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-filter">매장 추가</button>
						</div>
					</div>

					<div class="pull-right col-md-5">
						<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								매장명
								<span class="caret"></span> 
								<span class="sr-only">Toggle Dropdown</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">매장명</a></li>
								<li><a href="#">카테고리</a></li>
							</ul>
						</div>
							<input type="text" class="form-control" placeholder="검색어 입력">
							<span class="input-group-btn">
								<button class="btn btn-warning" type="button">Search</button>
							</span>
						</div>
					</div>
				</div>
				<div class="table-container table-responsive">
					<table class="table table-filter" id="extable">
						<tbody>
							<tr class="warning" align="center">
								<td>
									<div class="ckbox">
										<input type="checkbox" id="checkall"><label
											for="checkall"></label>
									</div>
								</td>
								<td>매장명</td>
								<td>음식종류</td>
								<td>평점</td>
								<td>매장 주소</td>
								<td>영업시간</td>
								<td>상세 설명</td>
							</tr>
							<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									ShopDto shopDto = list.get(i);
									String checkbox = "checkbox" + i;
							%>
							<tr>
								<td>
									<div class="ckbox">
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="<%=checkbox%>"> <label
											for="<%=checkbox%>"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta"><%=shopDto.getTitle() %></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=shopDto.getCategoryTitle() %></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getAddress()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getBusinessTime() %></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getScore()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getDetail() %></span>
										</div>
									</div>
								</td>
							</tr>
							    
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="btn-group pull-right">
					<button type="button" class="btn btn-warning">가나다순</button>
					<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<span class="caret"></span> 
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">가나다순</a></li>
						<li><a href="#">가입일순</a></li>
						<li><a href="#">신뢰도순</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>
	<%@ include file="/page/adminpage/include/pageNav.jsp"%>
