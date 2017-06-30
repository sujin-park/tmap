<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*, com.secondproject.admin.model.*"%>
<%@ include file="/page/adminpage/common/public.jsp"%>
<style type="text/css">
.table-filter tbody td:hover {
	cursor: pointer;
	background-color: #eee;
}
.table-filter tbody tr:hover {
	background-color: white;
}

</style>
<%
List<ExhibitionDto> list = (List<ExhibitionDto>) request.getAttribute("exhibitionList");
String order = (String) request.getAttribute("order");
PageNavigation pageNavigation = (PageNavigation) request.getAttribute("navigator");
%>
<section class="content page-top row">
	<div class="col-md-10 col-md-push-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<form name="exhibitionForm" method="post" action="">
						<div class="table-container table-responsive">
							<table class="table table-filter" id="extable">
								<tbody>
									<div class="row">
									<%
										int size = list.size();
										for (int i = 0; i < size; i++) {
											ExhibitionDto exhibitionDto = list.get(i);
										if (i == 3) {
									%>
										<tr>	
									<%
										} else {
									
									}
									%>
									     <td>
									      <table>
									      <tr>
									            <td colspan="2" align="center" height="150">
													<div class="col-md-6">
														<img src="<%=ContextPath.root%>/upload/<%=exhibitionDto.getExhibitionId()%>/<%=exhibitionDto.getExImage()%>" width="300" padding="0px"/>
													</div>
												</td>
									      </tr>
									      <tr>
									           <td colspan="2" align="center">
																<div class="media">
																	<div class="media-body">
																		<p class="media-meta"><%=exhibitionDto.getExTitle() %></p>
																	</div>
																</div>
															</td>
									      </tr>
									      <tr>
									            <td colspan="2" align="center">
													<div class="media">
														<div class="media-body">
															<div class="media-meta"><%=exhibitionDto.getExDesc() %></div>
																</div>
															</div>
												</td>
									      </tr>
									      </table>
									      </td>
									      <%
									      if (i == 3) {
									      %>
									      </tr>
									      <%
									      } else {
									      
									      }
									      
										}
									%>
								</div>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<%=pageNavigation.getNavigator()%>