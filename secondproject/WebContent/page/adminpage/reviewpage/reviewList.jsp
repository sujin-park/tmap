<%@page import="com.secondproject.util.PageNavigation"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.review.model.*"%>

<%
List<AdminReviewDto> list = (List<AdminReviewDto>) request.getAttribute("reviewList");
String order = (String) request.getAttribute("order");
PageNavigation pageNavigation = (PageNavigation) request.getAttribute("navigator");
%>
<section class="content page-top row">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-right">
					<form name="reviewForm" method="post" action="">
					<input type="hidden" name="act" value="blind">
						<div class="btn-group col-md-offset-2">
						<button type="button" class="btn btn-default btn-filter" onclick="javascript:moveWrite();">All</button>
							<button type="button" class="btn btn-warning btn-filter" onclick="javascript:blindReview();">Blind</button>
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
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=<%=order%>&column=orderby"  style="text-decoration:none; color:red">작성일</a></td>
								<td>작성자</td>
								<td>작성내용</td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=<%=order%>&column=trustby" style="text-decoration:none; color:red">신뢰점수</a></td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&order=<%=order%>&column=blindby" style="text-decoration:none; color:red">Blind</a></td>
							</tr>
							<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									AdminReviewDto adminReviewDto = list.get(i);
									String checkbox = "checkbox" + i;
									int blind = adminReviewDto.getIsBlind();
									if (blind == 1) {
							%>
							<tr style="background-color: #eee;" onclick="javascript:modal(<%=adminReviewDto.getReviewId()%>);">
							<%
									} else {
							%>
							<tr onclick="javascript:modal(<%=adminReviewDto.getReviewId()%>);">
							<%
									}
							%>
								<td>
									<div class="ckbox">
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="checkbox" value="<%=adminReviewDto.getReviewId()%>"> <label
											for="<%=checkbox%>"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta" id="<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getShopTitle()%></span>
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
											<div class="media-detail"><%=adminReviewDto.getContent()%></span>
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
					<input type="hidden" name="act" value="mvreview"> 
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
										<button class="btn btn-warning" type="button" onclick="javascript:searchReview();">Search</button>
									</span>
							</div>
						</div>
					</form>
			</div>
		</div>
	</div>
</section>
	<jsp:include page="/page/adminpage/include/modal.jsp"></jsp:include>
<script>
function blindReview() {
	if (confirm("블라인드 처리하시겠습니까?")) {
		document.reviewForm.action = "<%=ContextPath.root%>/review";
		document.reviewForm.submit();
		}
	
}

function searchReview() {
		if (document.searchForm.word.value == "")	{
			alert("검색어 입력!!!!!");
		} else {
			document.searchForm.action = "<%=ContextPath.root%>/admin";
			document.searchForm.submit();
		}
}

function modal(seq) {
	document.getElementById("modalsubject").value = document.getElementById(seq).textContent
	$('#myModal').modal({show:true});
	
}
</script>
<%=pageNavigation.getNavigator()%>