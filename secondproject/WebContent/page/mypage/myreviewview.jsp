<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath,com.secondproject.userdto.*"%>

<%UserDto udto = (UserDto)session.getAttribute("logininfo"); %>
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
	function com(){
		var text = $("#commenttext").val();
		var reviewId = $("#reviewId").val();
		
		document.location.href="<%=ContextPath.root %>/myreview?act=commentinsert&reviewId="+reviewId+"&text="+encodeURI(text);		
	}
</script>



<body class="a">
	<%
		MyReviewDto mrdto = (MyReviewDto) request.getAttribute("myreview");
		if (mrdto != null) {
	%>
		<div class="container">
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
		<div class="container">
			<div class="row">
				<div class="col-md-12 h-75 mar">
					<p class="" align=""><%=mrdto.getContent()%>

					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="container">
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
					<div class="container">
					<div class="map-container" align="">
						<div class="col-md-offset-3" id="map" style="width: 50%; height: 400px;"></div>
				<%	if(Integer.parseInt(mrdto.getUserId())!=udto.getUser_id()) {%>
			<div id="goba" class="pull-right">이 리뷰가 도움이 되었습니까?&nbsp;&nbsp;
			<% ReviewGoodBad goodbad = (ReviewGoodBad)request.getAttribute("goodbad"); %>
			<a href="javascript:like(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=mrdto.getReviewId()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/like<%=goodbad.getGood() %>.png"></a>
			<a href="javascript:hate(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=mrdto.getReviewId()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/hate<%=goodbad.getBad() %>.png"></a>
										</div><% } %>
					</div>

					<%
						}
					%>
			
			</div>
		</div>
		<div class="row mar">
			<div class="container">
			<a href="">댓글</a> 
						
			
		
		
		
			<div class="">
			<form method="post" action="" id="commentform" name="commentform">
			<input type="hidden" id="reviewId" name="reviewId" value="<%=mrdto.getReviewId()%>">
			<input type="hidden" name="act" value="commentinsert">
				<table style="margin-bottom: 100px;">
				<% List<ReviewCommentDto>  clist =(List<ReviewCommentDto>) request.getAttribute("clist"); %>
			
	
	
					<%	for(ReviewCommentDto cdto : clist) {
					
					%>
					<tr>
						<td width="10%" align="center" style="text-align: center;"><%=cdto.getEmail() %></td>
						<td colspan="2" width="90%"><%=cdto.getReviewContent() %></td>
					</tr>
						<% 
				}
				%>
					<tr>
						<td width="10%" align="center" style="text-align: center;"><%=udto.getEmail() %>
						<td width="80%"><textarea id="commenttext" rows="3" cols="130" ></textarea></td>	
						<td width="10%"><a href="javascript:com();" class="btnbtn" >입력</a></td>
					</tr>
				</table>
				</form>
			</div>
		</div>

</div>
</div>
