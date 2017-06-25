<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.secondproject.mypage.model.*,java.util.*"%>

<%
	List<FollowCategoryDto> list = (List<FollowCategoryDto>) request.getAttribute("favoriteCategoryList");
	if (list != null && list.size() != 0) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			FollowCategoryDto fcdto = list.get(i);
%>
<tr id="tr<%=fcdto.getFollowCategoryId()%>" name="trtr">
	<td id="<%=fcdto.getCategoryOrder()%>"><%=fcdto.getCategoryOrder()%></td>
	<td id="nana"><%=fcdto.getCategoryName()%>
		<div id="divv" class="pull-right">

			<a id="aa" class="btn btn-default"
				href="javascript:upOrder('<%=i + 1%>','<%=fcdto.getFollowCategoryId()%>');"
				role="button">▲</a> <a class="btn btn-default"
				href="javascript:downOrder('<%=i + 1%>','<%=fcdto.getFollowCategoryId()%>');"
				role="button">▼</a> <a id="dd" class="btn btn-default"
				href="javascript:catedelete('<%=fcdto.getFollowCategoryId()%>');"
				role="button">삭제</a>


		</div></td>
</tr>


<%
	}
	} else {
%>
<tr id="hh" name="hh">
	<td colspan="2">
		<center>등록한 카테고리가 없습니다.</center>
	</td>
</tr>
<%
	}
%>