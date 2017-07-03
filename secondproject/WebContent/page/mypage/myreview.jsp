<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath,com.secondproject.util.pagination.*"%>
	<%
	Pagination pagination = (Pagination) request.getAttribute("pagination");
	
	%>
<script type="text/javascript">
function viewreview(reviewId) {
	document.location.href="<%=ContextPath.root%>/myreview?act=viewreview&reviewId="+reviewId;

}

</script>


<div class="col-xs-9 col-md-9 col-xs-offset-1 a">

	
	
	<div class="map-container">
		<div id="map" style="width:100%;height:400px;"></div>
	</div>
	<h2 class="sub-header">내가 쓴 후기</h2>

 <div class="table-container table-responsive">
					<table class="table table-filter" id="extable">
						<thead>
							<tr class="warning">
								<td width="30%">가게정보</td>
								<td width="40%">제목</td>
								<td width="15%">좋아요</td>
								<td width="5%">댓글</td>
								<td width="10%">등록일</td>
							</tr>
						</thead>
						<tbody id="exShoplist">
							<%	List<MyReviewDto> myreviewlist = (List<MyReviewDto>) request.getAttribute("reviewlist"); 
							if(myreviewlist!=null) {
 								for(MyReviewDto mrdto : myreviewlist) {
 								
 	 
 	%>
						
							<tr>
								<td>
									<div class="media">
										
										<%=mrdto.getShopName() %>
										<%if(mrdto.getAddress()!=null) {
											%>
										
										<br><%=mrdto.getAddress() %>
										<%} %>
									</div>
								</td>
								<td>
									<div class="media">
									<a href="javascript:viewreview('<%=mrdto.getReviewId()%>');">
										<%=mrdto.getSubject() %>
										</a>
									</div>
								</td>
								<td>
									<div class="media">
										
									<%-- <%if(mrdto.getMyScore()!=null){ 
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
									}%> --%>
 									<img src="<%=ContextPath.root %>/page/mypage/img/like.png">
								<%=mrdto.getGood()%>
								<img src="<%=ContextPath.root %>/page/mypage/img/hate.png">
								<%=mrdto.getBad()%>

										
									</div>
								</td>
								<td>
									<div class="media">
										
										
										<%=mrdto.getCommentCnt() %>
									</div>
								</td>
								</td>
								<td>
									<div class="media">
										
										<%=mrdto.getUpdate_date() %>
										
									</div>
								</td>
								
								
							
							</tr>
							<%
								} 
								}
 	
							%>
								
						</tbody>
					</table>
					<center><%=pagination.getHtml() %><center>
				</div>
 
