<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"
   import="java.util.*, com.secondproject.admin.model.*,com.secondproject.constant.*"
   import="com.secondproject.util.pagination.*"%>
<%
ArrayList<OwnerConfirmDto> list = (ArrayList<OwnerConfirmDto>) request.getAttribute("list"); 
Pagination pagination = (Pagination) request.getAttribute("pagination");
String orderValue = (String) request.getAttribute("orderValue");
if (orderValue == null) {
	orderValue = "desc";
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

function modifyOwner(a) {
	if (confirm("인증을 진행하시겠습니까??")) {
		document.orderncolumn.ownerok.value = a;
		document.orderncolumn.action = "<%=ContextPath.root%>/admin";
		document.orderncolumn.submit();
	}
}

function moveOwnerList() {
	document.location.href ="<%=ContextPath.root%>/admin?act=realownerview&pg=1&key=&word=&orderValue=";
}

</script>
  
<section class="content page-top row">
   <div class="col-md-10 col-md-push-1" style="padding-top: 60px;">
      <div class="panel panel-default">
         <div class="panel-body">
            <div class="row">
               <div class="pull-left col-md-7">
                  <div class="btn-group">
							<button type="button" class="btn btn-warning btn-filter" onclick="modifyOwner(2);">사장 인증</button>
							<button type="button" class="btn btn-warning btn-filter" onclick="modifyOwner(3);">인증 거부</button>
							<button type="button" class="btn btn-warning btn-filter" onclick="moveOwnerList();">사장 LIST</button>
                  </div>
               </div>
               <div class="col-md-5">
               </div>
             </div>
             <form name="orderncolumn" method="post" action="">
              <input type="hidden" name="ownerok" value="ownermodify">
  
            <input type="hidden" name="act" value="ownermodify">
             <div class="table-container">
                <table class="table table-filter">
                   <tbody>
                      <tr class="warning" align="center">
                       <td>
                       <div class="ckbox">
                       <input type="checkbox" id="th_checkAll" onclick="checkAll();"/><label for="checkbox"></label>
                       </div>
                       </td>
                        <td><a href="<%=ContextPath.root%>/admin?act=ownerview&orderValue=<%=orderValue%>&orderKey=email" style="text-decoration:none">사장아이디</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=ownerview&orderValue=<%=orderValue%>&orderKey=reg_date" style="text-decoration:none">가입일</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=ownerview&orderValue=<%=orderValue%>&orderKey=title" style="text-decoration:none">가게이름</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=ownerview&orderValue=<%=orderValue%>&orderKey=tel" style="text-decoration:none">전화번호</a></td>
                         <td><a href="<%=ContextPath.root%>/admin?act=ownerview&orderValue=<%=orderValue%>&orderKey=address" style="text-decoration:none">주소</a></td>
                     </tr>
                     <tr>
                     <%int size = list.size();
                  	 if (size != 0) { 
                     for (int i = 0; i<size; i++) {
                    	 OwnerConfirmDto ownerConfirmDto = list.get(i);
                        String checkbox = "checkbox" + i;
                     %>
                        <td>
                           <div class="ckbox">
                              <input type="checkbox" id="<%=checkbox%>" name="checkRow" value="<%=ownerConfirmDto.getUserEmail()%>"> <label for="<%=checkbox%>"></label>
                           </div>
                        </td>
                     
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <p class="media-meta"><%= ownerConfirmDto.getUserRegDate()%></p>
                              </div>
                           </div>
                        </td>
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <p class="media-meta"><%= ownerConfirmDto.getShopTitle()%></p>
                              </div>
                           </div>
                        </td>
                    
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=ownerConfirmDto.getShopTel()%></span>
                              </div>
                           </div>
                        </td>
                   
                        <td>
                           <div class="media">
                              <div class="media-body">
                                 <span class="media-meta"> <%=ownerConfirmDto.getShopAddress()%></span>
                              </div>
                           </div>
                        </td>
                     </tr>
                     <%} 
                     } else {%>
                     <tr>
                     <td colspan="6">
                           <div class="media">
                              <div class="media-body">
                                 <p class="media-meta">새로 가입한 회원이 없습니다.</p>
                              </div>
                           </div>
                        </td>
                     </tr>
                     <% } %>
  		            </form>
                  </tbody>
               </table>
            <div class="form-group form-inline">
            <div align="center">
            <form name="searchForm" method="get" action="">
               <input type="hidden" name="act" value="ownerview">
                  <div class="pull-right col-md-5">
                     <div class="input-group">
                        <div class="input-group-btn">
                        <select class="form-control" name="key_type">
                           <option value="email">사장아이디</option>
                           <option value="reg_date">가입일</option>                           
                           <option value="title">가게이름</option>
                           <option value="tel">전화번호</option>                           
                           <option value="address">주소</option>
                        </select>
                     </div>
                     <input type="text" class="form-control" name = "keyword" placeholder="검색어 입력" size="25">
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
   </div>
<div align="center" style="clear:both;">
<%=pagination.getHtml()%>
</div>
<div class="col-md-6"></div>
</section>