<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"
   import="java.util.*, com.secondproject.userdto.*,com.secondproject.constant.*"%>
<%String root = request.getContextPath();
ArrayList<UserDto> list = (ArrayList<UserDto>) request.getAttribute("list"); 
String userOrder = (String) request.getAttribute("userOrder");
if (userOrder == null) {
   userOrder = "desc";
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
	if (confirm("삭제하시겠습니까?")) {
		document.orderncolumn.action = "<%=ContextPath.root%>/admin";
		document.orderncolumn.submit();
	}
}

</script>
  
<section class="content page-top">
   <div class="col-md-10 col-md-push-1">
      <div class="panel panel-default">
         <div class="panel-body">
            <div class="row">
               <div class="pull-left col-md-7">
                  <div class="btn-group">
                    <div class="btn-group">
                    
							<button type="button" class="btn btn-warning btn-filter" onclick="deleteUser();">회원 삭제</button>
						</div>
       
                  </div>
               </div>
         <form name="searchForm" method="get" action="">
   
               <input type="hidden" name="act" value="userview">
                  <div class="pull-right col-md-5">
                     <div class="input-group">
                        <div class="input-group-btn">
                        <select class="form-control" name="key_type">
                           <option value="user_id">아이디</option>
                           <option value="type">회원타입</option>                           
                           <option value="reg_date">가입일</option>
                           <option value="gender">성별</option>                           
                           <option value="age">나이</option>
                        </select>
                     </div>
                     <input type="text" class="form-control" name = "keyword" placeholder="검색어 입력" size="3">
                        <button class="btn btn-warning" type="button" onclick="searchUser();">Search</button>
                  </div>
                  </div>
            </form>
             </div>
             <form name="orderncolumn" method="post" action="">
            <input type="hidden" name="act" value="userdelete">
             <div class="table-container">
                <table class="table table-filter">
                   <tbody>
                      <tr class="warning" align="center">
                       <td><input type="checkbox" id="th_checkAll" onclick="checkAll();"/><label for="checkbox"></label></td>
                        <td><a href="<%=ContextPath.root%>/admin?act=userview&userorder=<%=userOrder%>&column=user_id" style="text-decoration:none">아이디</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=userview&userorder=<%=userOrder%>&column=type" style="text-decoration:none">회원타입</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=userview&userorder=<%=userOrder%>&column=reg_date" style="text-decoration:none">가입일</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=userview&userorder=<%=userOrder%>&column=gender" style="text-decoration:none">성별</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=userview&userorder=<%=userOrder%>&column=age" style="text-decoration:none">나이</a></td>
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
                                 <p class="media-meta"><%= userDto.getType()%></p>
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
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=userDto.getGender()%></span>
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
                     </tr>
                     
                     <%} %>
                     </input>
                     </form>
                     
                  </tbody>
               </table>
            </div>
            <!-- <div class="btn-group pull-right">
               <button type="button" class="btn btn-warning">가나다순</button>
               <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <span class="caret"></span> 
                  <span class="sr-only">Toggle Dropdown</span>
               </button>
               <ul class="dropdown-menu" role="menu">
                  <li><a href="#">가나다순</a></li>
                  <li><a href="#">가입일순</a></li>
                  <li><a href="#">신뢰도순</a></li>
               </ul>
            </div> -->
         </div>
      </div>
   </div>
</section>
<%@ include file="/page/adminpage/include/pageNav.jsp"%>