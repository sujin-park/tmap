<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.review.model.*, java.util.*"%>
<%
List<AdminReviewDto> list = (List<AdminReviewDto>) request.getAttribute("reviewList");
%>
<%
								int size = list.size();
								for (int i = 0; i < size; i++) {
									AdminReviewDto adminReviewDto = list.get(i);
									String checkbox = "checkbox" + i;
									int blind = adminReviewDto.getIsBlind();
									if (blind == 1) {
							%>
							<tr style="background-color: #eee;">
							<%
									} else {
							%>
							<tr>
							<%
									}
							%>
								<td>
									<div class="ckbox">
										<input type="checkbox" class="checkthis" id="<%=checkbox%>" name ="checkbox" value="<%=adminReviewDto.getReviewId()%>"> 
										<label for="<%=checkbox%>"></label>
									</div>
								</td>
								<td>
									<div class="media">
										<span class="media-meta" id="shop<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getShopTitle()%></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=adminReviewDto.getRegDate()%></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta" id="email<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getEmail()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<div class="media-detail" id="content<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getContent()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta" id="score<%=adminReviewDto.getReviewId()%>"><%=adminReviewDto.getScore()%></span>
										</div>
									</div>
								</td>
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Edit">
										<button type="button" class="btn btn-warning btn-xs" 
							    		 onclick="javascript:modal(<%=adminReviewDto.getReviewId()%>);"><span class="glyphicon glyphicon-pencil"></span>
							    		</button>
							    	</p>
							    </td>
							</tr>
							    
							<%
									}
								
							%>