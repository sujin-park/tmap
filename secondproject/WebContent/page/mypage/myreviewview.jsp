<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath"%>

<script type="text/javascript">
function viewreview(reviewId) {

}

</script>


	
	<body class="a">
	<%	MyReviewDto mrdto = (MyReviewDto) request.getAttribute("myreview"); 
							if(mrdto!=null) {
 								
 	 
 	%>
  <div class="section py-5" id="features">
    <div class="container">
      <div class="row">
        <div class="col-md-12 marr">
          <h1 class="pb-4 text-primary" align="center"><%=mrdto.getSubject() %>
            <br>
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="row">
           <div class="col-md-12 mar">
 				<div class="pull-right">내가한평점:<%if(mrdto.getMyScore()!=null){ 
										
										for(int i=0;i<Integer.parseInt(mrdto.getMyScore()); i++) {
											%>★<%
 										}
									}%>  등록일 :<%=mrdto.getUpdate_date() %></div>
 					</div>
            <div class="col-md-12 mar">
				<div class="pull-right">	up: <%=mrdto.getGood() %> /down: <%=mrdto.getBad() %></div>
				</div>
				
 	
 	
 	 	
 	
 	
		
            </div>
          </div>
        </div>
      </div>
       <div class="container">
      <div class="row">
        <div class="col-md-12 h-75">
          <p class=""><%=mrdto.getContent() %>
            
          </p>
        </div>
      </div>
      </div>
      <div class="row">
      <div class="container">
        <div class="col-md-12 col-md-offset-4">
			<%=mrdto.getShopName() %><br>
 			<%=mrdto.getReserveUrl() %> <br>
 			 <%=mrdto.getAddress() %><br>
 			<%=mrdto.getTel() %><br>
 			<%=mrdto.getBusinessTime() %><br>
 			<%=mrdto.getDetail() %>
          <div class="map-container" align="">
		<div id="map" style="width:25%;height:300px;"></div>
	</div>
            
      <%} %>	
      </div>   
        </div>
      </div>
      </div>
