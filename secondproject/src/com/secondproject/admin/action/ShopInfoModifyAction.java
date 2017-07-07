package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.ShopInfoServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.util.Encoding;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class ShopInfoModifyAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		
		String orderValue = (String) params.get("orderValue");
		if (orderValue.isEmpty()) {
			orderValue = "asc";
		}
		ArrayList<ShopInfoDto> shoplist= ShopInfoServiceImpl.getShopInfoService().getArticles(params);
		
		if (orderValue.equals("asc")) {
			orderValue = "desc";
		} else {
			orderValue = "asc";
		}
		int cnt = 0;
		int seq = Integer.parseInt(request.getParameter("seq"));
		String cate = Encoding.isoToEuc(request.getParameter("cate"));
		String shopname = Encoding.isoToUtf(request.getParameter("shopname"));
		String shopnum = request.getParameter("shopnum");
		String shopadd = request.getParameter("shopadd");
		ShopInfoDto shopInfoDto = new ShopInfoDto();
		shopInfoDto.setShopId(seq);
		shopInfoDto.setCategoryName(cate);
		shopInfoDto.setShopTitle(shopname);
		shopInfoDto.setTel(shopnum);
		shopInfoDto.setAddress(shopadd);
		System.out.println(shopname + " SHOP MODIFY");
		cnt = ShopInfoServiceImpl.getShopInfoService().modifyShopInfo(shopInfoDto);
		List<ShopInfoDto> shopList= ShopInfoServiceImpl.getShopInfoService().getArticles(params);
		int totalUserCount = CommonServiceImpl.getCommonService().totalShopCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalUserCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/admin?act=shopinfo");
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		String queryString = QueryString.getQueryString(params, filter);
		
		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		System.out.println(shopList.size() + "SHOP MODIFY");
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", orderValue);
		request.setAttribute("shoplist", shopList);
		return "/page/adminpage/shop/shopInfoModify.jsp";
	}

}
