
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



<a class="btn a" id="modal-611669" role="button"
	href="#modal-container-611669" data-toggle="modal">카테고리</a>

<div class="modal fade" id="modal-container-611669" role="dialog"
	aria-hidden="true" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">

				<button class="close" aria-hidden="true" type="button"
					data-dismiss="modal">×</button>
				<h4 class="modal-title" id="myModalLabel">카테고리</h4>
			</div>
			<div class="modal-body">
				<div class="row table-responsive">
					<form id="orderForm" name="orderForm" method="post" action="">
						<input type="hidden" name="act" value=""> <input
							type="hidden" name="id" value="">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>순서</th>
									<th>카테고리이름</th>

								</tr>
							</thead>
							<tbody>


								<%
									List<FollowCategoryDto> list = (List<FollowCategoryDto>) request.getAttribute("followCategoryList");
									int size = list.size();
									for (int i = 0; i < size; i++) {
										FollowCategoryDto fcdto = list.get(i);
								%>
								<tr>
									<td><%=fcdto.getCategoryOrder()%></td>
									<td><%=fcdto.getCategoryName()%>
										<div class="pull-right">
											<%
												if (i == 0) {
											%>

											<a class="btn btn-default" href="javascript:first();"
												role="button">△</a>
											<%
												} else {
											%>
											<a class="btn btn-default"
												href="javascript:upOrder('<%=fcdto.getFollowCategoryId()%>');"
												role="button">▲</a>
											<%
												}
											%>

											<%
												if (i + 1 == size) {
											%>
											<a class="btn btn-default" href="javascript:last();"
												role="button">▽</a>
											<%
												} else {
											%>
											<a class="btn btn-default"
												href="javascript:downOrder('<%=fcdto.getFollowCategoryId()%>');"
												role="button">▼</a>

											<%
												}
											%>
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
			<div class="modal-footer">
				<button class="btn btn-primary" type="button"
					onclick="javascript:categoryMake();">추가</button>
				<button class="btn btn-default" type="button" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>