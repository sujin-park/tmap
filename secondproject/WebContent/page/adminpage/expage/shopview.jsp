<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.admin.model.*, java.util.*, com.secondproject.shop.model.*"%>
<%
	ExhibitionDto exhibitionDto = (ExhibitionDto) request.getAttribute("exhibitionInfo");
	List<ShopDto> list = (List<ShopDto>) request.getAttribute("shopList");
%>
<%
							if (list != null) {
								int size = list.size();
								for (int i = 0; i < size; i++) {
									ShopDto shopDto = list.get(i);
									String checkbox = "checkbox" + i;
							%>
							<tr>
								
								<td>
									<div class="media">
										<span class="media-meta"><%=shopDto.getTitle() %></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=shopDto.getCategoryTitle() %></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getAddress()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getBusinessTime() %></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getScore()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getDetail() %></span>
										</div>
									</div>
								</td>
								<td>
								<p data-placement="top" data-toggle="tooltip" title="Delete">
								<button type="button" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" onclick="javascript:deleteShoplist(<%=exhibitionDto.getExhibitionId()%>, <%=shopDto.getShopId()%>);" ><span class="glyphicon glyphicon-trash"></span></button></p>
								</td>
							</tr>
							<%
								}
								}
							%>