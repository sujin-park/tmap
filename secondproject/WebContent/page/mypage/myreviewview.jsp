<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>

<script type="text/javascript">

	function like(good,bad,reviewId){
		if(good==1) {
			$.get("/secondproject/myreview?act=goodbad&good=0&bad=0&reviewId="+reviewId, function(data, status){
				var goba = document.getElementById("goba");
				goba.innerHTML=data;
			});
		} else {
			$.get("/secondproject/myreview?act=goodbad&good=1&bad=0&reviewId="+reviewId, function(data, status){
				var goba = document.getElementById("goba");
				goba.innerHTML=data;
		});
		}
		
	}
	function hate(good,bad,reviewId){
		if(bad==1) {
			$.get("/secondproject/myreview?act=goodbad&good=0&bad=0&reviewId="+reviewId, function(data, status){
				var goba = document.getElementById("goba");
				goba.innerHTML=data;
		});
		} else {
			$.get("/secondproject/myreview?act=goodbad&good=0&bad=1&reviewId="+reviewId, function(data, status){
				var goba = document.getElementById("goba");
				goba.innerHTML=data;
		});
		}
	}

</script>



<body class="a">
	<%
		MyReviewDto mrdto = (MyReviewDto) request.getAttribute("myreview");
		if (mrdto != null) {
	%>
		<div class="container" style="background-color: #dbdbdb;">
		<input type="hidden" id="reviewLat" value="<%=mrdto.getLat()%>">
		<input type="hidden" id="reviewLng" value="<%=mrdto.getLng()%>">
	<div class="section py-5" id="features">
			<div class="row">
				<div class="col-md-12 marr">
					<h1 class="pb-4 text-primary" align="center"><%=mrdto.getSubject()%>
						<br>
					</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="row">
					<div class="col-md-12" align="right">수정 &nbsp;삭제</div>
						<div class="col-md-12 mar">
							<div class="pull-right">
								<%if(mrdto.getMyScore()!=null){ 
										int cnt = Integer.parseInt(mrdto.getMyScore());
										int star = cnt/2;
										int halfstar=cnt%2;
										for(int i=0;i<star; i++) {
											%><img src="<%=ContextPath.root %>/page/mypage/img/star.png" width="35px"><%
 										}
										if(halfstar==1) {
											%>
											<img src="<%=ContextPath.root %>/page/mypage/img/halfstar.gif" width="35px">
											<% 
										}
									}%>
								<%=mrdto.getUpdate_date()%></div>
						</div>
						<div class="col-md-12 mar">
							<div class="pull-right">
								<img src="<%=ContextPath.root %>/page/mypage/img/like1.png">
								<%=mrdto.getGood()%>
								<img src="<%=ContextPath.root %>/page/mypage/img/hate1.png">
								<%=mrdto.getBad()%></div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="container" style="background-color: #dbdbdb;">
			<div class="row">
				<div class="col-md-12 h-75 mar">
					<p class="" align="center"><%=mrdto.getContent()%>

					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="container" style="background-color: #dbdbdb;">
				<div class="col-md-12 " style="text-align: center;">
					<%=mrdto.getShopName()%>&nbsp;
					<a href="<%=mrdto.getReserveUrl()%>">예약하기</a>
					<br>
					<%=mrdto.getAddress()%><br>
					<%=mrdto.getTel()%><br>
					<%=mrdto.getBusinessTime()%><br>
					<%=mrdto.getDetail()%>
					</div>
					</div>
					<div class="container" style="background-color: #dbdbdb;">
					<div class="map-container" align="">
						<div class="col-md-offset-3" id="map" style="width: 50%; height: 400px;"></div>
					
			<div id="goba" class="pull-right">이 리뷰가 도움이 되었습니까?&nbsp;&nbsp;
			<% ReviewGoodBad goodbad = (ReviewGoodBad)request.getAttribute("goodbad"); %>
			<a href="javascript:like(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=mrdto.getReviewId()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/like<%=goodbad.getGood() %>.png"></a>
			<a href="javascript:hate(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=mrdto.getReviewId()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/hate<%=goodbad.getBad() %>.png"></a>
										</div>
					</div>

					<%
						}
					%>
			
			</div>
		</div>
		<div class="row mar">
			<div class="container" style="background-color: #dbdbdb;">
			<a href="">댓글</a> 
								
			<% List<ReviewCommentDto>  clist =(List<ReviewCommentDto>) request.getAttribute("clist"); 
				for(ReviewCommentDto cdto : clist) {
					
					%>
					<%=cdto.getReviewContent() %>
					<% 
				}
				%>
			
			</div>
		</div>

</div>