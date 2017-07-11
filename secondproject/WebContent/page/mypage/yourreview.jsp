<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath,com.secondproject.util.pagination.*,com.secondproject.userdto.*"%>
	<%
	UserDto udto = (UserDto)session.getAttribute("logininfo");
	UserDto fudto = (UserDto) request.getAttribute("followUserDto");
	Pagination pagination = (Pagination) request.getAttribute("pagination");
	%>
<script type="text/javascript">
function viewreview(reviewId) {
	document.location.href="<%=ContextPath.root%>/myreview?act=viewreview&reviewId="+reviewId;

}
function follow(followUserId) {
	document.location.href="<%=ContextPath.root%>/mypage?act=followadd&followUserId="+followUserId;
}

</script>

<div class="container">
<div class="col-xs-12 col-md-12 a">

	
	
	<div class="map-container">
		<div id="map" style="width:100%;height:400px;"></div>
	</div>
	<div class=row>
		<%if(udto.getUser_id()==fudto.getUser_id()) {%>
				<h4>내가 쓴 후기</h4>
		<% } else {%>
			<h4 class="sub-header"><%=fudto.getEmail() %>님이 쓴 후기&nbsp;&nbsp;
			<%if(fudto.getUser_id()!=0 && fudto.getUser_id()!=udto.getUser_id()) { %>
			<button class="btn btn-primary" type="button" onclick="follow('<%=fudto.getUser_id()%>');">팔로우</button>
			<%} %>
			</h4> 
		<%} %>
	</div>
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
										<input type="hidden" id="reviewLat" value="37.484168">
										<input type="hidden" id="reviewLng" value="126.9004223">
										
										<%if(mrdto.getAddress()!=null) {
											%>
										<%=mrdto.getShopName() %>
										
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
	 									<img src="<%=ContextPath.root %>/page/mypage/img/like1.png">
										<%=mrdto.getGood()%>
										<img src="<%=ContextPath.root %>/page/mypage/img/hate1.png">
										<%=mrdto.getBad()%>
									</div>
								</td>
								<td>
									<div class="media">
										<%=mrdto.getCommentCnt() %>
									</div>
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
 
	</div>
</div>