<%@page import="com.sun.glass.ui.Size"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.secondproject.mypage.model.*"%>
<div class="col-xs-9 col-md-9 col-xs-offset-1">
	<div class="row table-responsive a">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>순서</th>
				<th>카테고리이름</th>

			</tr>
		</thead>
		<tbody>
		<%
		List<FavoriteCategoryDto> list =(List<FavoriteCategoryDto>)request.getAttribute("favoriteCategoryList"); 
		int size = list.size();
		System.out.print(size);
		for(FavoriteCategoryDto fcdto: list) {
		%>
			<tr>
				<td><%=fcdto.getCategoryOrder() %></td>
				<td><%=fcdto.getCategoryName() %>
				<div class="pull-right"><a class="btn btn-default" href="#" role="button">▲</a>
 					<a class="btn btn-default" href="#" role="button">▼</a></div></td>
			</tr>
		<%} %>
		</tbody>
	</table>
	</div>
</div>