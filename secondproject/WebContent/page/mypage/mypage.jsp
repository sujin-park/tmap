<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath "%>
<script type="text/javascript" src="<%=ContextPath.root%>/page/mypage/js/myajax.js"></script>
<script type="text/javascript"> 
    function upOrder(order,id) {
    	if(order==1) {
    	return alert("첫번째 순서입니다.");
    	} else {
    	document.orderForm.act.value = "upOrder"; 
    	document.orderForm.id.value=id;
    	document.orderForm.action="<%=ContextPath.root%>/mypage";
        document.orderForm.submit();
    	}
    }

    function downOrder(order,id) {
    	if(document.getElementsByName("trtr").length==order) {
    		return alert("마지막 순서입니다.");
    	} else {
    	document.orderForm.act.value = "downOrder";
    	document.orderForm.id.value = id;
    	document.orderForm.action = "<%=ContextPath.root%>/mypage";
		document.orderForm.submit();
    	}
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
 
	function getData() {
		
		var catename = $("#text").val();
		var name = "act=catemake&catename=" + encodeURI(catename);
		sendRequest("/secondproject/mypage", name, receiveBookData, "GET");
	}
	
	function receiveBookData() {
		if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {
				var bookxml = httpRequest.responseXML;
				viewData(bookxml);//<book><title>제목</title><price>1000</price></book>
			} else {
				alert("문제발생 : " + httpRequest.status);
			}
		}
	}
	function viewData(category) {
		var cateid = category.getElementsByTagName("cateid")[0].firstChild.data;
		var order = category.getElementsByTagName("order")[0].firstChild.data;
		var name = category.getElementsByTagName("name")[0].firstChild.data;
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		var txtorder = document.createTextNode(order);
		td.appendChild(txtorder);
		var td2 = document.createElement("td");
		var txtname = document.createTextNode(name);
		td2.appendChild(txtname);
		var div = document.createElement("div");
		div.setAttribute("class","pull-right");
		var a2 = document.createElement("a");
		a2.setAttribute("class","btn btn-default");
		a2.setAttribute("href","javascript:upOrder('"+order+"','"+cateid+"');");
		a2.setAttribute("role","button");
		a2.appendChild(document.createTextNode("▲"));
		var a4 = document.createElement("a");
		a4.setAttribute("class","btn btn-default");
		a4.setAttribute("href","javascript:downOrder('"+order+"','"+cateid+"');");
		a4.setAttribute("role","button");
		a4.appendChild(document.createTextNode("▼"));
		div.appendChild(a2);
		div.appendChild(document.createTextNode(" "));
		div.appendChild(a4);
		td2.appendChild(div);
		tr.setAttribute("name","trtr");
		tr.appendChild(td);
		tr.appendChild(td2);
		var tt = document.getElementById("tt");
		tt.appendChild(tr); 
		$("#text").empty();
		
	}
	
	
</script>
		<div class="col-xs-9 col-md-9 col-xs-offset-1 a">

			<h2 class="sub-header">팔로우 관리</h2>

			<div class="form-group form-inline">
				<div class="row mar">
					<div class="col-xs-6">
						<select
							name="" onchange="" class="form-control">
							<option value="all">전체</option>
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
				    		if(fulist!=null) {	
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
				      <% }
									} else { %>팔로우한사람이 없습니다.
									<% }%>
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
							<tbody id="tt" name="tt">


								<%
									List<FollowCategoryDto> list = (List<FollowCategoryDto>) request.getAttribute("favoriteCategoryList");
								if(list!=null) {	
								int size = list.size();
									for (int i = 0; i < size; i++) {
										FollowCategoryDto fcdto = list.get(i);
								%>
								<tr name="trtr">
									<td id="<%=fcdto.getCategoryOrder()%>"><%=fcdto.getCategoryOrder()%></td>
									<td id="nana"><%=fcdto.getCategoryName()%>
										<div id="divv" class="pull-right">
											
											<a id="aa" class="btn btn-default"
												href="javascript:upOrder('<%=i+1%>','<%=fcdto.getFollowCategoryId() %>');"
												role="button">▲</a>
											
											<a class="btn btn-default"
												href="javascript:downOrder('<%=i+1%>','<%=fcdto.getFollowCategoryId() %>');"
												role="button">▼</a>

											
										</div></td>
								</tr>


								<%
									}
								} else {
									%>
									등록한 카테고리가 없습니다. 	
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
				<input type="text" id="text" name="catename" class="marright"><button id="btn" class="btn btn-primary" type="button"
					onclick="getData();">추가</button>
				<button class="btn btn-default" type="button" data-dismiss="modal">취소</button>
				</form>
			</div>
		</div>
	</div>
</div>