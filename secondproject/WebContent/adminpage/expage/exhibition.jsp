<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.admin.model.*"%>
<%
List<ExhibitionDto> list = (List<ExhibitionDto>) request.getAttribute("exhibitionList");
%>
<section class="content page-top">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-left col-md-7">
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-filter" onclick="javascript:moveWrite();">기획전 등록</button>
							<button type="button" class="btn btn-warning btn-filter">기획전 삭제</button>
						</div>
					</div>

					<div class="pull-right col-md-5">
						<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								가나다순
								<span class="caret"></span> 
								<span class="sr-only">Toggle Dropdown</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">기획전이름</a></li>
								<li><a href="#">매장명</a></li>
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
					<table class="table table-filter">
						<tbody>
							<tr class="warning" align="center">
								<td>Check</td>
								<td>사진</td>
								<td>기획전명</td>
								<td>내용</td>
								<td>노출여부</td>
								<td>배치 순서</td>
							</tr>
							<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									ExhibitionDto exhibitionDto = list.get(i);
							%>
							<tr>
								<td>
									<div class="ckbox">
										<input type="checkbox" id="checkbox1"> <label
											for="checkbox1"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta"><%=exhibitionDto.getExImage() %></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=exhibitionDto.getExTitle() %></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=exhibitionDto.getExDesc() %></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=exhibitionDto.getExVisiable() %></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=exhibitionDto.getExOrder() %></span>
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
	<%@ include file="/adminpage/include/pageNav.jsp"%>
<script>
function moveWrite(){
	document.location.href = "<%=ContextPath.root%>/exhibition?act=mvwrite";
}
</script>