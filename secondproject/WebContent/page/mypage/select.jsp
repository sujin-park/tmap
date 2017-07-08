<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.secondproject.mypage.model.*,java.util.*"%>
<%
	List<FollowUserDto> list = (List<FollowUserDto>) request.getAttribute("followselect");
	if (list != null && list.size() != 0) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			FollowUserDto fudto = list.get(i);
%>

<tr>
	<td><%=fudto.getEmail() %></td>
	<td ><%=fudto.getStatusMsg()%>
		<div id="divv" class="pull-right">
		<a id="aa" class="btn btn-default" href="javascript:follow('<%=fudto.getUserId()%>');" role="button">팔로우</a>

		</div></td>
</tr>


<%
	} 
		} else {
%>
<tr id="" name="">
	<td colspan="2">
		<center>검색 결과가 없습니다.</center>
	</td>
</tr>
<%
	}
%>