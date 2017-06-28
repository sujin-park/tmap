<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>




<div class="col-xs-9 col-md-9 col-xs-offset-1 a">

	
	
	<div class="map-container">
		<div id="map" style="width:100%;height:400px;"></div>
	</div>
	<h2 class="sub-header">내가 쓴 후기</h2>
 	<% 
 	List<MyReviewDto> myreviewlist = (List<MyReviewDto>) request.getAttribute("reviewlist");
 	 for(MyReviewDto mrdto : myreviewlist) {
 		 
 	 
 	%> <%=mrdto.getShopName() %>  평점:<%for(int i=0;i<Integer.parseInt(mrdto.getShopScore()); i++) {
 	%>★<%
 	}%>   <button id="" class="btn btn-primary" type="button">수정</button> <button id="" class="btn btn-primary" type="button">삭제</button>
 		<br><%=mrdto.getAddress() %>
 		<br><%=mrdto.getSubject() %>  내가준별점 : <%for(int i=0;i<Integer.parseInt(mrdto.getMyScore()); i++) {
 	%>★<%
 	}%>
 		<br><%=mrdto.getContent() %>
 		<br>수정일 : <%=mrdto.getUpdate_date() %>
 		<br>	
 	<%} %>
 </div>
