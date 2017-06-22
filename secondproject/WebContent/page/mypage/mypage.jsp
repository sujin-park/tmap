<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>

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
	
	function modal() {
		$('#modal').modal({show:true});
	}
	function check(){
	    cbox = input_form.chk;
	    if(cbox.length) {  // 여러 개일 경우
	        for(var i = 0; i<cbox.length;i++) {
	            cbox[i].checked=input_form.all.checked;
	        }
	    } else { // 한 개일 경우
	        cbox.checked=input_form.all.checked;
	    }
	}
	function categoryMake() {
		document.catemake.act.value ="catemake"; 
    	document.catemake.action="<%=ContextPath.root%>/mypage";
        document.catemake.submit();
	}
	
</script>
		<div class="col-xs-9 col-md-9 col-xs-offset-1 a">


			<h2 class="sub-header">팔로우 관리</h2>

			<div class="form-group form-inline">
				<div class="row mar">
					<div class="col-xs-6">
						<select
							name="" onchange="" class="form-control">
							<option value="">전체</option>
							<option value="">키트리</option>
							<option value="">한식</option>
							<option value="">내맘대로</option>
						</select>
					</div>
					<div class="col-xs-6">
						<div class="pull-right">
						  <a class="btn btn-default" href="javascript:modal();" role="button">그룹관리</a>
						  <a class="btn btn-default" href="#" role="button">그룹이동</a>
						  <a class="btn btn-default" href="#" role="button">삭제</a>
						</div>
					</div>
					
				</div>
				<div class="row table-responsive">
				<form name="input_form">
					<table class="table table-bordered">
				    <thead>
				      <tr>
				        <th class="center"><input type="checkbox" class="lar" name="all" onclick="javascript:check();"></th>
				        <th>카테고리</th>
				        <th>id  |  상태메세지</th>
				        <th>최근후기등록일</th>
				        <th>팔로우한날짜</th>
				        <th>별칭 </th>
				      </tr>
				    </thead>
				    <tbody>
				    	<%
									List<FollowUserDto> fulist = (List<FollowUserDto>) request.getAttribute("list");
									int size = fulist.size();
									for (int i = 0; i < size; i++) {
										FollowUserDto fudto = fulist.get(i);
								%>
				      <tr>
				        <td class="center"><input type="checkbox"  name="chk" class="lar"></td>
				        <td><%=fudto.getCategoryName()%></td>
				        <td><%=fudto.getEmail() %> | <%=fudto.getStatusMsg() %></td>
				        <td><%=fudto.getRegDate() %></td>
				        <td><%=fudto.getFavoriteRegDate() %></td>
				        <% String a =fudto.getAlias();
				        if(a==null) {
				        	a="없음";
				        	%>
				        <td><%=a %></td>
				        <% 
				        } else {%>
				        <td><%=fudto.getAlias() %></td>
				      <%} %>
				      </tr>
				      <% } %>
				    </tbody>
				  </table>
				  </form>
				</div>
				
			</div>
			<div>
				
			</div>
		</div>

		
<div class="modal fade" id="modal" role="dialog"
	aria-hidden="true" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
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
						<table id="info" class="table table-bordered">
							<thead>
								<tr>
									<th>순서</th>
									<th>카테고리이름</th>

								</tr>
							</thead>
							<tbody>


								<%
									List<FollowCategoryDto> list = (List<FollowCategoryDto>) request.getAttribute("favoriteCategoryList");
									size = list.size();
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
				<form name=catemake method="post">
				<input type="hidden" name="act">
				<input type="text" name="catename" class="marright"><button class="btn btn-primary" type="button"
					onclick="javascript:categoryMake();">추가</button>
				<button class="btn btn-default" type="button" data-dismiss="modal">취소</button>
				</form>
			</div>
		</div>
	</div>
</div>