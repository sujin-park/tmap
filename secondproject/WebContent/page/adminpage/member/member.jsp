<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"
   import="java.util.*, com.secondproject.userdto.*,com.secondproject.constant.*"
   import="com.secondproject.util.pagination.*"%>
<%
List<UserDto> list = (List<UserDto>) request.getAttribute("list");
String orderValue = (String) request.getAttribute("orderValue");
Pagination pagination = (Pagination) request.getAttribute("pagination");

if (orderValue == null) {
	orderValue = "asc";
	}
%>
<script>
function searchUser() {
   if (document.searchForm.keyword.value == "") {
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
		alert("탈퇴시킬 회원을 선택해주세요");
	} else if (confirm("회원을 탈퇴시키겠습니까?")) {
		document.orderncolumn.action = "<%=ContextPath.root%>/admin";
		document.orderncolumn.submit();
	}
}

</script>
  
<section class="content page-top row">
   <div class="col-md-10 col-md-push-1" style="padding-top: 60px;">
      <div class="panel panel-default">
         <div class="panel-body">
            <div class="row">
               <div class="pull-left col-md-3">
                  <div class="btn-group">
                    <div class="btn-group">
							<button type="button" class="btn btn-warning btn-filter" onclick="deleteUser();">회원 삭제</button>
						</div>
       
                  </div>
               </div>
             </div>
             <div class="table-container">
                <table class="table table-filter">
                   <tbody>
             		<form name="orderncolumn" method="post" action="">
            		<input type="hidden" name="act" value="userdelete">
                      <tr class="warning" align="center">
                       <td>
                       <div class="ckbox">
                       <input type="checkbox" id="th_checkAll" onclick="checkAll();"/><label for="checkbox"></label>
                       </div>
                       </td>
                        <td width="25%"><a href="<%=ContextPath.root%>/admin?act=userview&orderValue=<%=orderValue%>&orderKey=user_id" style="text-decoration:none">아이디</a></td>
                         <td width="25%"><a href="<%=ContextPath.root%>/admin?act=userview&orderValue=<%=orderValue%>&orderKey=type" style="text-decoration:none">회원타입</a></td>
                         <td width="10%"><a href="<%=ContextPath.root%>/admin?act=userview&orderValue=<%=orderValue%>&orderKey=gender" style="text-decoration:none">성별</a></td>
                         <td width="20%"><a href="<%=ContextPath.root%>/admin?act=userview&orderValue=<%=orderValue%>&orderKey=age" style="text-decoration:none">나이</a></td>
                         <td width="20%"><a href="<%=ContextPath.root%>/admin?act=userview&orderValue=<%=orderValue%>&orderKey=reg_date" style="text-decoration:none">가입일</a></td>
                     </tr>
                     <tr>
                     <%int size = list.size();
                  
                     for (int i = 0; i<size; i++) {
                        UserDto userDto = list.get(i);
                        String checkbox = "checkbox" + i;
                     %>
                        <td>
                           <div class="ckbox">
                              <input type="checkbox" id="<%=checkbox%>" name="checkRow" value="<%=userDto.getUser_id()%>"> <label for="<%=checkbox%>"></label>
                           </div>
                        </td>
                     
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <p class="media-meta"><%= userDto.getUser_id()%></p>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                <%--  <p class="media-meta"><%= userDto.getType()%></p> --%>
                                 <span class="media-meta"> 
                                 <%if (userDto.getType() == 0) {%>
                                 	
                                 	<% } else if(userDto.getType() == 1) {%>
                                 	회원
                                 	<% } else {%>
                                 	사장
                                 	<% } %>
                                 	</span>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> 
                                 <%if (userDto.getGender() == 1) {%>
                                 	남성
                                 	<% } else {%>
                                 	여성
                                 	<% } %>
                                 </span>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=userDto.getAge()%></span>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=userDto.getReg_date()%></span>
                              </div>
                           </div>
                        </td>
                     </tr>
                     <%} %>
                     </form>
                  </tbody>
               </table>
               <div class="form-group form-inline">
				   <div align="center">
	               <form name="searchForm" method="get" action="">
	               <input type="hidden" name="act" value="userview">
	                  <div class="pull-right col-md-5">
						<div class="input-group">
							<div class="input-group-btn">
								<select class="form-control" name="key">
									<option value="emailname">작성자명</option>
									<option value="shopname">매장명</option>
								</select>
							</div>
							<input type="text" class="form-control" name="word" placeholder="검색어 입력" size="25">
								<span class="input-group-btn">
								<button class="btn btn-warning" type="button" onclick="javascript:searchReview();">Search</button>
								</span>
						</div>
					 </div>
	            </form>
	           </div>
            </div>
         </div>
        </div>
      </div>
   </div>
</section>
<div align="center">
<%=pagination.getHtml()%>
</div>
<div class="col-md-6"></div>