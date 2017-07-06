<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.admin.model.*, com.secondproject.constant.*, java.util.*"%>
<%
 	List<ShopInfoDto> shoplist = (List<ShopInfoDto>) request.getAttribute("shoplist");
	if (shoplist!=null ){ 
%>
                     <tr>
                     <%int size = shoplist.size();
                  
                     for (int i = 0; i<size; i++) {
                    	 ShopInfoDto shopInfoDto = shoplist.get(i);
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
 <%}
                     }%>
