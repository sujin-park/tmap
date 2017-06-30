<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>

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
							<tr class="warning" align="center">
								<td>리뷰제목</td>
								<td>별점</td>
								<td>등록일</td>
								<td>가게정보</td>
							</tr>
						</thead>
						<tbody id="exShoplist">
							<%	List<MyReviewDto> myreviewlist = (List<MyReviewDto>) request.getAttribute("reviewlist"); 
							if(myreviewlist!=null) {
 								for(MyReviewDto mrdto : myreviewlist) {
 								
 	 
 	%>
						
							<tr align="center">
								
								<td>
									<div class="media">
									<a href="javascript:viewreview('<%=mrdto.getReviewId()%>');">
										<%=mrdto.getSubject() %>
										</a>
									</div>
								</td>
								<td>
									<div class="media">
										
									<%if(mrdto.getMyScore()!=null){ 
										
										for(int i=0;i<Integer.parseInt(mrdto.getMyScore()); i++) {
											%>★<%
 										}
									}%>
 	

										
									</div>
								</td>
								<td>
									<div class="media">
										
										<%=mrdto.getUpdate_date() %>
										
									</div>
								</td>
								<td>
									<div class="media">
										
										<%=mrdto.getShopName() %><br>
										<%=mrdto.getAddress() %>
										
									</div>
								</td>
								
							
							</tr>
							<%
								} 
								}
 	
							%>
								
						</tbody>
					</table>
				</div>
 
