<%@page import="com.secondproject.util.PageNavigation"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.review.model.*"
	import="com.secondproject.util.pagination.*"%>
<%
List<AdminReviewDto> list = (List<AdminReviewDto>) request.getAttribute("reviewList");
String orderValue = (String) request.getAttribute("orderValue");
Pagination pagination = (Pagination) request.getAttribute("pagination");
if (orderValue == null) {
	orderValue = "asc";
	}
%>
<script>
function blindReview() {
	var valueArr = new Array();
	$("input[name=checkbox]:checked").each(function() {
		valueArr.push($(this).val());
	});
	if (valueArr == "") {
		alert("삭제할 기획전을 선택해주세요");
	} else if (confirm("블라인드 처리하시겠습니까?")) {
		document.reviewForm.action = "<%=ContextPath.root%>/adminreview";
		document.reviewForm.submit();
		}
	
}

function blindReviewOne() {
	var reviewseq = document.getElementById("reviewseq").value;
	$.get("/secondproject/adminreview?act=blindOne&reviewseq="+ reviewseq, function(data, status){
		var tt = document.getElementById("reviewList");
		tt.innerHTML=data;
		$('#myModal').modal('hide');
	});

}

function searchReview() {
		if (document.reviewSearchForm.word.value == "")	{
			alert("검색어 입력!!!!!");
		} else {
			document.reviewSearchForm.action = "<%=ContextPath.root%>/admin";
			document.reviewSearchForm.submit();
		}
}

function modal(reviewimg,seq) {
	
	document.getElementById("reviewseq").value = seq;
	document.getElementById("modalshop").value = document.getElementById("shop"+seq).textContent;
	document.getElementById("modalemail").value = document.getElementById("email"+seq).textContent;
	document.getElementById("modalcontent").value = document.getElementById("content"+seq).textContent;
	document.getElementById("modalscore").innerHTML = document.getElementById("score"+seq).textContent;
	
	$('#reimg').attr("src", "<%=ContextPath.root%>/upload/" + reviewimg);
	
	$('#myModal').modal({show:true});
	
}
</script>
<section class="content page-top row"  >
	<div class="col-md-10 col-md-push-1" style="padding-top: 60px; padding-bottom: 60px;">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="pull-left col-md-3">
					<form name="reviewForm" method="post" action="">
					<input type="hidden" name="review_img" value="">
					<input type="hidden" name="act" value="blind">
						<div class="btn-group col-md-offset-2">
							<button type="button" class="btn btn-warning btn-filter" onclick="javascript:blindReview();">Blind</button>
						</div>
					</div>
				</div>
				<div class="table-container table-responsive">
					
					<table class="table table-filter" id="extable">
						<thead>
							<tr class="warning" align="center">
								<td>
									<div class="ckbox">
										<input type="checkbox" id="checkedAll"><label
											for="checkedAll"></label>
									</div>
								</td>
								<td width="20%">매장명</td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&orderKey=orderby&orderValue=<%=orderValue%>"  style="text-decoration:none; color:red">작성일</a></td>
								<td>작성자</td>
								<td width="30%">작성내용</td>
								<td><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&orderKey=trustby&orderValue=<%=orderValue%>" style="text-decoration:none; color:red">매장 평점</a></td>
								<td width="10%"><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&orderKey=blindby&orderValue=<%=orderValue%>" style="text-decoration:none; color:red">Blind</a></td>
							</tr>
						</thead>
						<tbody id="reviewList">
							<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									AdminReviewDto adminReviewDto = list.get(i);
									String checkbox = "checkbox" + i;
									int blind = adminReviewDto.getIsBlind();
									if (blind == 1) {
							%>
							<tr style="background-color: #eee;">
							
							<%
									} else {
							%>
							<tr>
							<%
									}
							%>
								<td>
									<div class="ckbox">
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="checkbox" value="<%=adminReviewDto.getReviewId()%>"> 
										<label for="<%=checkbox%>"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta" id="shop<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getShopTitle()%></span>
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
											<span class="media-meta" id="email<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getEmail()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<div class="media-detail" id="content<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getContent()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta" id="score<%=adminReviewDto.getReviewId()%>" value="<%=adminReviewDto.getScore()%>">
											<%if(adminReviewDto.getScore()!=0){ 
                              					int cnt = adminReviewDto.getScore();
                              					int star = cnt/2;
                              					int halfstar=cnt%2;
                              					for(int j=0; j<star; j++) {
                                				 %><img src="<%=ContextPath.root %>/page/mypage/img/star.png" width="20px"><%
                              					 }
                             					 if(halfstar==1) {
                                				 %>
                                				 <img src="<%=ContextPath.root %>/page/mypage/img/halfstar.gif" width="20px">
                                 				 <% 
                             					 }
                           						 }%>
											</span>
										</div>
									</div>
								</td>
								<td>
									<p align="center" data-placement="top" data-toggle="tooltip" title="Edit">
										<button type="button" class="btn btn-warning btn-xs" 
							    		 onclick="javascript:modal('<%=adminReviewDto.getImg()%>',<%=adminReviewDto.getReviewId()%>);"><span class="glyphicon glyphicon-pencil"></span>
							    		</button>
							    	</p>
							    </td>
							</tr>
							    
							<%
									}
								
							%>
						</tbody>
					</table>
			<div class="form-group form-inline">
				<div align="center">
					<form name="reviewSearchForm" method="get" action="">
						<input type="hidden" name="act" value="mvreview"> 
							 <div class="pull-right col-md-5">
	               				<div class="input-group">
	                 				 <div class="input-group-btn">
										<select class="form-control" name="key">
										  	<option value="emailname">작성자명</option>
										  	<option value="shopname">매장명</option>
										</select>
									</div>
										<input type="text" class="form-control" name="word" placeholder="검색어 입력" size="25">
										<span class="input-group-btn">
											<button class="btn btn-warning" type="button" onclick="javascript:searchReview();">Search</button>
										</span>
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
		</form>
	</div>
</div>
</div>
<jsp:include page="/page/adminpage/reviewpage/modal.jsp"></jsp:include>
<div align="center" style="clear:both;">
<%=pagination.getHtml()%>
</div>
<div class="col-md-6"></div>
</section>