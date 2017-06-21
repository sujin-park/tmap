
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>
<script type="text/javascript"> 
    function upOrder(id) {
    	document.orderForm.act.value = "upOrder"; 
    	document.orderForm.id.value=id;
    	document.orderForm.action="<%=ContextPath.root%>/mypage";
        document.orderForm.submit();
    }
    function downOrder(id) {
    	document.orderForm.act.value = "downOrder";
    	document.orderForm.id.value = id;
    	document.orderForm.action = "<%=ContextPath.root%>/mypage";
		document.orderForm.submit();
	}
    function first() {
    	alert("첫번째 순서 입니다");
		return;
    }
    function last() {
    	alert("마지막 순서입니다");
		return;
    }
</script>
<div class="col-xs-9 col-md-9 col-xs-offset-1">
	<div class="row table-responsive a">
		<form id="orderForm" name="orderForm" method="post" action="">
			<input type="hidden" name="act" value=""> 
			<input type="hidden" name="id" value="">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>순서</th>
						<th>카테고리이름</th>

					</tr>
				</thead>
				<tbody>


					<%
						List<FollowCategoryDto> list = (List<FollowCategoryDto>) request.getAttribute("favoriteCategoryList");
						int size = list.size();
						for (int i=0;i<size;i++) {
							FollowCategoryDto fcdto = list.get(i);
					%>
					<tr>
						<td><%=fcdto.getCategoryOrder()%></td>
						<td><%=fcdto.getCategoryName()%>
							<div class="pull-right">
					<%
					if(i==0) {
					%>
					
								<a class="btn btn-default"
									href="javascript:first();"
									role="button">△</a>
							<% } else { %>
							<a class="btn btn-default"
									href="javascript:upOrder('<%=fcdto.getFollowCategoryId()%>');"
									role="button">▲</a>
							<% }%>	
							
						<%
						if(i+1==size) {
							%> <a class="btn btn-default"
										href="javascript:last();"
										role="button">▽</a>
						<%} else {
						%>		 
									 <a class="btn btn-default"
									href="javascript:downOrder('<%=fcdto.getFollowCategoryId()%>');"
									role="button">▼</a>
									
									<%} %>
							</div></td>
					</tr>


					<%
						}
					%>

				</tbody>
			</table>
		</form>
	</div>
</div>