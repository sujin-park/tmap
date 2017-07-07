<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.admin.model.*, com.secondproject.constant.*"%>
<%
 	ShopInfoDto shopInfoDto = (ShopInfoDto) request.getAttribute("shopInfo");
%>
<input type="hidden" id="shoplat" value="<%=shopInfoDto.getLat()%>" />
<input type="hidden" id="shoplng" value="<%=shopInfoDto.getLng()%>" />
			<div class="row">
					<div class="col-md-12" id="shopInfoOne">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
										<input type="hidden" id="shopinform" value="<%=shopInfoDto.getShopId()%>">
											<label for="inputName">카테고리</label> <input type="text"
												class="form-control" name="subject" id="shop_title"
												value="<%=shopInfoDto.getCategoryName()%>">
										</div>
										<label for="inputStore">매장명</label>
											<div class="input-group">
												<input type="text" class="form-control" id="shop_name"
													name="store" value="<%=shopInfoDto.getShopTitle()%>">
											</div>
										<div class="form-group">
												<label for="inputName">매장번호</label> <input type="text"
													class="form-control" name="subject" id="shop_tel"
													value="<%=shopInfoDto.getShopTel()%>">
										</div>
										<div class="form-group">
												<label for="inputName">주소</label> <input type="text"
													class="form-control" name="subject" id="shop_add"
													value="<%=shopInfoDto.getShopAddress()%>">
										</div>
									</div>
									<div class="col-md-6">
											<img id="shop_img" src="<%=ContextPath.root%>/page/main/img/shopimg/<%=shopInfoDto.getShopId()%>.jpg" width="350" height="250" style="margin-top:20px"/>
									</div>
								</div>
									<div class="form-group">
										<div class="col-md-2">
										<div class="map-container mar" align="">
											<div class="col-md-offset-3" id="map" style="width: 750px; height: 300px;"></div>
										</div>
									</div>
									</div>
							</div>
						</div>
					</div>
			</div>