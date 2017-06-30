<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.admin.model.*"
	import="com.secondproject.shop.model.*, com.secondproject.util.*"%>
<%
List<ShopDto> list = (List<ShopDto>) request.getAttribute("exShopList");
int seq = Integer.parseInt((String) request.getAttribute("exhibitionId"));
PageNavigation pageNavigation = (PageNavigation) request.getAttribute("navigator");
%>
<script>

function searchShop() {
	if (document.searchForm.word.value == "")	{
		alert("검색어 입력!!!!!");
	} else {
		document.searchForm.action = "<%=ContextPath.root%>/exhibition";
		document.searchForm.submit();
	}
}

function plusShop() {
	if (confirm("매장을 등록하시겠습니까?")) {
	document.updateForm.action = "<%=ContextPath.root%>/exhibition";
	document.updateForm.submit();
	}
	}

</script>
<section class="content page-top">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-left col-md-7">
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-filter" onclick="javascript:plusShop();">매장 추가</button>
						</div>
					</div>
				<form name="searchForm" method="get" action="">
					<input type="hidden" name="act" value="mvshoplist"> 
					<div class="pull-right col-md-5">
						<div class="input-group">
							<div class="input-group-btn">
									<select class="form-control" name="key">
									  	<option value="title">매장명</option>
									  	<option value="category">카테고리명</option>
									</select>
						</div>
							<input type="text" class="form-control" placeholder="검색어 입력" name="word">
							<span class="input-group-btn">
								<button class="btn btn-warning" type="button" onclick="javascript:searchShop();">Search</button>
							</span>
						</div>
					</div>
				</form>
				</div>
				<form name="updateForm" method="post" action="">
				<input type="hidden" name="act" value="plusshop">
				<input type="hidden" name="seq" value="<%=seq%>">
				<div class="table-container table-responsive">
					<table class="table table-filter" id="extable">
						<tbody>
							<tr class="warning" align="center">
								<td>
									<div class="ckbox">
										<input type="checkbox" id="checkedAll"><label
											for="checkedAll"></label>
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
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="shoplist" value="<%=shopDto.getShopId()%>"> <label
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
											<span class="media-meta"></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getAddress() %></span>
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
				</form>
				<div class="btn-group pull-right">
									<select class="form-control" name="key">
									  	<option value="shopname">매장명순</option>
									  	<option value="category">카테고리순</option>
									</select>
								</div>
				</div>
			</div>
		</div>
</section>
<%=pageNavigation.getNavigator()%>