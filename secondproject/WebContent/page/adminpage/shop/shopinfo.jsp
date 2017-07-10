<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"
   import="java.util.*, com.secondproject.admin.model.ShopInfoDto,com.secondproject.constant.*"
   import="com.secondproject.util.pagination.*"%>
<%
   ArrayList<ShopInfoDto> list = (ArrayList<ShopInfoDto>) request.getAttribute("list"); 
   String orderValue = (String) request.getAttribute("orderValue");
   Pagination pagination = (Pagination) request.getAttribute("pagination");
if (orderValue == null) {
   orderValue = "asc";
   }
%>
<script>
function searchUser() {
   if (document.searchForm.word.value == "") {
      alert("검색어 입력!!!!!");
   } else {
      document.searchForm.action = "<%=ContextPath.root%>/admin";
      document.searchForm.submit();
   }
}

function column(){
       document.searchForm.action = "<%=ContextPath.root%>/admin";
       document.searchForm.submit();
}

function checkAll(){
    if( $("#th_checkAll").is(':checked') ){
      $("input[name=checkRow]").prop("checked", true);
    }else{
      $("input[name=checkRow]").prop("checked", false);
    }
}

function deleteUser() {
   var valueArr = new Array();
   $("input[name=checkRow]:checked").each(function() {
      valueArr.push($(this).val());
   });
   if (valueArr == "") {
      alert("삭제할 매장을 선택해주세요");
   } else if (confirm("삭제하시겠습니까?")) {
      document.orderncolumn.action = "<%=ContextPath.root%>/admin";
      document.orderncolumn.submit();
   }
}

function shopmodal(seq) {
   $.get("/secondproject/adminshop?act=showShopInfo&shopseq="+ seq, function(data, status){
      var tt = document.getElementById("shopInfoOne");
      tt.innerHTML=data;
      $('#shopModal').modal({show:true});
      initMap();
   });

}

	function follow(followUserId) {
		document.location.href="<%=ContextPath.root%>/mypage?act=followadd&followUserId="+followUserId;
	}
	 function firstArticle() {
		 document.location.href="<%=ContextPath.root%>/mypage?act=followView&pg=1&key=&word=";
			
		   
		}

	function listArticle(mvpg) {
	
	document.location.href="<%=ContextPath.root%>/mypage?act=followView&pg="+mvpg+"&key=&word=&control=";
	
	}


	function upOrder(order, id) {
		if (order == 1) {
			return alert("첫번째 순서입니다.");
		} else {
			$.get("/secondproject/mypage?act=upOrder&id="+id, function(data, status){
				var tt = document.getElementById("tt");
				tt.innerHTML=data;
			});
		}
	}
var followUserId;

	function modifymake(){
		var alias = $("#alias").val();
		var memo = $("#memo").val();

		document.location.href = "<%=ContextPath.root%>/mypage?act=followmodify&followUserId=" + followUserId+"&alias="+encodeURI(alias)+"&memo="+encodeURI(memo);
	}

	function downOrder(order, id) {
		if (document.getElementsByName("trtr").length == order) {
			return alert("마지막 순서입니다.");
		} else {
			$.get("/secondproject/mypage?act=downOrder&id="+id, function(data, status){
				var tt = document.getElementById("tt");
				tt.innerHTML=data;
			});
		}
	}
	function catedelete(id) {
		var catename = $("#text").val();
		if(confirm("정말삭제하시겠습니까?")) {
			$.get("/secondproject/mypage?act=catedelete&cateid="+id, function(data, status){
				var tt = document.getElementById("tt");
				tt.innerHTML=data;
	        });
			
		}
	
	}
	function modal() {
		$('#modal').modal({
			show : true
		});
	}
	function modalmemo() {
		$('#modalmemo').modal({
			show : true
		});
	}
	function modalcate() {
		$('#modalcate').modal({
			show : true
		});
	}
	function followmodal() {
		$('#followmodal').modal({
			show : true
		});
	}
	function check() {
		cbox = input_form.chk;
		if (cbox.length) { // 여러 개일 경우
			for (var i = 0; i < cbox.length; i++) {
				cbox[i].checked = input_form.all.checked;
			}
		} else { // 한 개일 경우
			cbox.checked = input_form.all.checked;
		}
	}
	function getData() {
		var catename = $("#text").val();
		if(catename.length>100){
			return alert("카테고리 이름이 너무 길어요");
		} else if(catename.trim()=="") {
			return alert("카테고리 이름을 입력하세요");
		} else {
		$.get("/secondproject/mypage?act=catemake&catename="+ encodeURI(catename), function(data, status){
			var tt = document.getElementById("tt");
			tt.innerHTML=data;
		});
		}
		$("#text").val('');
	}
	function getMemoData(id) {
		$.get("/secondproject/mypage?act=followUser&followuserid="+id, function(data, status){
			var form = document.getElementById("cateForm");
			form.innerHTML=data;
		});
		modalmemo();
		followUserId=id;
	}
	
	

	function followdelete() {
		var valueArr = new Array();
		var list = $("input[name='chk']");
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되어 있으면 배열에 값을 저장함
				valueArr.push(list[i]);
			}
		}

	} 
	var valueArr;
	$(document).ready(function() {
		$("#getCheckedAll").click(function() {
			valueArr = new Array();
			$("input[name=chk]:checked").each(function() {
				valueArr.push($(this).val());
			});
			if (valueArr == "") {
				alert("선택하세요");
			} else {
				 document.location.href = "<%=ContextPath.root%>/mypage?act=followdelete&seq="+valueArr;
			
			}
		});
		 $("#catemodify").click(function() {
			valueArr = new Array();
			$("input[name=chk]:checked").each(function() {
				valueArr.push($(this).val());
			});
			if (valueArr == "") {
				alert("선택하세요");
			} else {
				modalcate();	
				
			}
		}); 
		 $('#modal').on('hidden.bs.modal', function (e) {
			  document.location.href = "<%=ContextPath.root%>/mypage?act=followView&pg=1";
			})
		$('#modalmemo').on('hidden.bs.modal', function (e) {
			document.location.href = "<%=ContextPath.root%>/mypage?act=followView&pg=1";
			})
		$('#modalcate').on('hidden.bs.modal', function (e) {
			document.location.href = "<%=ContextPath.root%>/mypage?act=followView&pg=1";
			})
		$('#followmodal').on('hidden.bs.modal', function (e) {
			document.location.href = "<%=ContextPath.root%>/mypage?act=followView&pg=1";
			})
	});	
	function select() {
		var id =$("select[name=select]").val();
	 	document.location.href="<%=ContextPath.root%>/mypage?act=followView&pg=1&key=category_name&word="+encodeURI(id);
		
	}
	function modicate() {
		var cateid =$("select[name=modicate]").val();
		
		document.location.href="<%=ContextPath.root%>/mypage?act=catemodify&id="+cateid+"&seq="+valueArr;
		
		
	}

	$(document).on('click', '#bttn', function() {
		var selectname = $("#followselect").val();
<%-- 		document.location.href="<%=ContextPath.root%>/mypage?act=followSelect&pg=1&word="+encodeURI(selectname); --%>
		$.get("/secondproject/mypage?act=followSelect&pg=1&word="+encodeURI(selectname), function(data, status){
			var div = document.getElementById("tbodyselect");
			div.innerHTML=data;
		});
	});

	function searchfollow() {
		if (document.searchfollowForm.word.value == "")	{
			alert("검색어 입력!!!!!");
		} else {
			document.searchfollowForm.action = "<%=ContextPath.root%>/mypage";
			document.searchfollowForm.submit();
		}
	}
	/* $(document).on('click', '#follow', function() {
			alert($("#db").val());
	
	}); */
	

</script> 
<section class="content page-top row">
   <div class="col-md-10 col-md-push-1" style="padding-top: 60px;">
      <div class="panel panel-default">
         <div class="panel-body">
            <div class="row">
               <div class="pull-left col-md-7">
                  <div class="btn-group">
                    <div class="btn-group">
                    
                     <button type="button" class="btn btn-warning btn-filter" onclick="deleteUser();">매장 삭제</button>
                  </div>
                  </div>
               </div>
             </div>
             <div class="col-xs-6">
				<div class="pull-right">
					<a class="btn btn-default" href="javascript:followmodal();" role="button">매장검색</a>
					<a class="btn btn-default" href="javascript:modal();" role="button">그룹관리</a>
					<a class="btn btn-default" id="catemodify" role="button">그룹이동</a> <a
						class="btn btn-default" role="button" id="getCheckedAll">삭제</a>
				</div>
			</div>
             <form name="orderncolumn" method="post" action="">
            <input type="hidden" name="act" value="shopdelete">
             <div class="table-container">
                <table class="table table-filter">
                   <thead>
                      <tr class="warning" align="center">
                       <td>
                       <div class="ckbox">
                       <input type="checkbox" id="th_checkAll" onclick="checkAll();"/><label for="checkbox"></label>
                  </div>
                       </td>
                         <td width="15%"><a href="<%=ContextPath.root%>/admin?act=shopinfo&orderValue=<%=orderValue%>&orderKey=category_title" style="text-decoration:none">카테고리</a></td>
                        <td width="25%"><a href="<%=ContextPath.root%>/admin?act=shopinfo&orderValue=<%=orderValue%>&orderKey=title" style="text-decoration:none">매장명</a></td>
                         <td width="15%"><a href="<%=ContextPath.root%>/admin?act=shopinfo&orderValue=<%=orderValue%>&orderKey=tel" style="text-decoration:none">매장 번호</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=shopinfo&orderValue=<%=orderValue%>&orderKey=address" style="text-decoration:none">주소</a></td>
                <%--          <td><a href="<%=ContextPath.root%>/admin?act=shopinfo&shopInfoOrder=<%=shopInfoOrder%>&column=shop_id" style="text-decoration:none">기획전여부</a></td> <!-- 기획전 있는지 없는지 여부 --> --%>
                         <td>EDIT</td>
                     </tr>
                     </thead>
                     <tbody id="shopNew">
                     <tr>
                     <%int size = list.size();
                  
                     for (int i = 0; i<size; i++) {
                        ShopInfoDto shopInfoDto = list.get(i);
                        String checkbox = "checkbox" + i;
                     %>
                        <td>
                           <div class="ckbox">
                              <input type="checkbox" id="<%=checkbox%>" name="checkRow" value="<%=shopInfoDto.getShopTitle()%>"> <label for="<%=checkbox%>"></label>
                           </div>
                        </td>
                     
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> 
                                 <%=shopInfoDto.getCategoryName()%>
                                    </span>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <p class="media-meta"><%= shopInfoDto.getShopTitle()%></p>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=shopInfoDto.getShopTel()%></span>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> 
                                 <%=shopInfoDto.getShopAddress()%>
                                    
                                 </span>
                              </div>
                           </div>
                        </td>
                        <td>
                     <p data-placement="top" data-toggle="tooltip" title="Edit">
                        <button type="button" class="btn btn-warning btn-xs" 
                          onclick="javascript:shopmodal(<%=shopInfoDto.getShopId()%>);"><span class="glyphicon glyphicon-pencil"></span>
                        </button>
                     </p>
                  </td>
                     </tr>
                     
                     <%} %>
                     </form>
                  </tbody>
               </table>
            </div>
             <div class="form-group form-inline">
           <div align="center">
               <form name="searchForm" method="get" action="">
               <input type="hidden" name="act" value="shopinfo">
                  <div class="pull-right col-md-5">
                     <div class="input-group">
                        <div class="input-group-btn">
                        <select class="form-control" name="key">
                           <option value="title">매장명</option>
                           <option value="category_title">카테고리</option>                           
                           <option value="tel">매장번호</option>
                           <option value="address">주소</option>                           
                          <!--  <option value="shop_id">기획전</option> -->
                        </select>
                     </div>
                     <input type="text" class="form-control" name = "word" placeholder="검색어 입력" size="25">
                        <span class="input-group-btn">
                           <button class="btn btn-warning" type="button" onclick="searchUser();">Search</button>
                        </span>
                  </div>
                  </div>
            </form>
            </div>
         </div>
        </div>
         </div>
      </div>
           
<div class="modal fade" id="modal" role="dialog" aria-hidden="true"
	aria-labelledby="myModalLabel">
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
									if (list != null && list.size()!=0) {
										int size2 = list.size();
										for (int i = 0; i < size2; i++) {
											ShopInfoDto ssdto = list.get(i);
								%>
								<tr id="tr<%=ssdto.getShopTitle()%>" name="trtr">
									<td id="<%=ssdto.getShopTitle()%>"><%=ssdto.getShopTitle()%></td>
									<td id="<%=ssdto.getShopTitle()%>" name="<%=ssdto.getShopTitle()%>"><%=ssdto.getShopTitle()%>
										<div id="divv" class="pull-right">

											<a id="aa" class="btn btn-default"
												href="javascript:upOrder('<%=i + 1%>','<%=ssdto.getCategoryName()%>');"
												role="button">▲</a> <a class="btn btn-default"
												href="javascript:downOrder('<%=i + 1%>','<%=ssdto.getCategoryName()%>');"
												role="button">▼</a>
												<a id="dd" class="btn btn-default"
												href="javascript:catedelete('<%=ssdto.getCategoryName()%>');"
												role="button">삭제</a>


										</div></td>
								</tr>


								<%
									}
									} else {
								%>
								<tr id="hh" name="hh">
								<td colspan="2">
								<center>
									등록한 카테고리가 없습니다.
								</center>
								</td>
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
					<input type="hidden" name="act"> <input type="text" class="marright" id="text" name="text"
									placeholder="Category Name">
					<button id="btn" class="btn btn-primary" type="button"
						onclick="getData();" name="make">추가</button>
					<button class="btn btn-default" type="button" data-dismiss="modal">취소</button>
				</form>
			</div>
		</div>
	</div>
</div>   
      
      
      
      
      
<%@include file="/page/adminpage/shop/shopInfoModal.jsp"%>
<div align="center" style="clear:both;">
<%=pagination.getHtml()%>
</div>
<div class="col-md-6"></div>
</section>