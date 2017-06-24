<%@page import="com.secondproject.util.PageNavigation"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.review.model.*"%>

<%
List<AdminReviewDto> list = (List<AdminReviewDto>) request.getAttribute("reviewList");
//String order = (String) request.getAttribute("order");
PageNavigation pageNavigation = (PageNavigation) request.getAttribute("navigator");
%>
<section class="content page-top row">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-right col-md-offset-2">
					<form name="reviewForm" method="post" action="">
					<input type="hidden" name="act" value="delete">
						<div class="btn-group">
						<button type="button" class="btn btn-default btn-filter" onclick="javascript:moveWrite();">All</button>
							<button type="button" class="btn btn-warning btn-filter" onclick="javascript:deleteExhibition();">Blind</button>
						</div>
					</div>
					
					<!-- <div class="pull-right col-md-5">
						<div class="btn-group pull-right">
							<select class="form-control" name="key">
									  	<option value="orderby">배치순</option>
									  	<option value="nameby">가나다순</option>
									  	<option value="visiableby">노출여부순</option>
									</select>
						</div>
					</div> -->
				</div>
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
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=desc&column=nameby"  style="text-decoration:none; color:red">작성일</a></td>
								<td>작성자</td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=desc&column=visiableby" style="text-decoration:none; color:red">작성내용</a></td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=desc&column=orderby" style="text-decoration:none; color:red">신뢰점수</a></td>
								<td>Edit</td>
							</tr>
							<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									AdminReviewDto adminReviewDto = list.get(i);
									String checkbox = "checkbox" + i;
									
							%>
							<tr>
								<td>
									<div class="ckbox">
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="checkbox" value="<%=adminReviewDto.getReviewId()%>"> <label
											for="<%=checkbox%>"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta"><%=adminReviewDto.getShopTitle()%></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=adminReviewDto.getRegDate()%></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=adminReviewDto.getEmail()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=adminReviewDto.getContent()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=adminReviewDto.getScore()%></span>
										</div>
									</div>
								</td>
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Edit">
										<button type="button" class="btn btn-warning btn-xs" 
							    		onclick="javascript:viewExhibition('<%=adminReviewDto.getReviewId()%>');"><span class="glyphicon glyphicon-pencil"></span>
							    		</button>
							    	</p>
							    </td>
							</tr>
							    
							<%
								}
							%>
						</tbody>
					</table>
					</form>
				</div>
				<form name="searchForm" method="get" action="">
					<input type="hidden" name="act" value="mvexhibition"> 
						<div class="pull-right col-md-5">
							<div class="input-group">
								<div class="input-group-btn">
									<select class="form-control" name="key">
									  	<option value="emailname">작성자명</option>
									  	<option value="shopname">매장명</option>
									</select>
								</div>
									<input type="text" class="form-control" name="word" placeholder="검색어 입력" size="3">
									<span class="input-group-btn">
										<button class="btn btn-warning" type="button" onclick="javascript:searchExhibition();">Search</button>
									</span>
							</div>
						</div>
					</form>
			</div>
		</div>
	</div>
</section>
<%=pageNavigation.getNavigator()%>