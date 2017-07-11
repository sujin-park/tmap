package com.secondproject.review.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.constant.ContextPath;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.user.service.UserServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.QueryString;

public class ReviewViewAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setBoardParameter(request);
		HashMap<String, Object> parameterMap = getParameterMap();
		
		String contentPath = "";
		int reviewId = NumberCheck.nullToZero(request.getParameter("reviewId"));
		ReviewDto reviewDto = ReviewServiceImpl.getReviewService().getReview(reviewId);
		UserDto userDto = UserServiceImpl.getUserService().getUser(reviewDto.getUserId());
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(reviewDto.getShopId());

		if (reviewDto != null && userDto != null && reviewDto.getIsBlind() == 0) {

			HttpSession session = request.getSession();
			UserDto loginUserDto = (UserDto) session.getAttribute("logininfo");
			
			LinkedHashMap<String, String> linkMap = new LinkedHashMap<String, String>();
			
			String queryString = QueryString.getQueryString(parameterMap);
			String listHref = "<a href=\"" + ContextPath.root + "/shop?act=view&shopId=" + shopDto.getShopId() + queryString + "\" class=\"btn btn-primary\">목록</a>";
			linkMap.put("list", listHref);
			
			if (loginUserDto != null && loginUserDto.getUser_id() == reviewDto.getUserId()) {
				linkMap.put("modify", "<a href=\"" + ContextPath.root + "/review?act=modifyForm&reviewId=" + reviewDto.getReviewId() + "\" class=\"btn btn-primary\">수정</a>");
				linkMap.put("delete", "<a href=\"" + ContextPath.root + "/review?act=delete&reviewId=" + reviewDto.getReviewId() + "\" class=\"btn btn-primary\">삭제</a>");
			}
			
			request.setAttribute("reviewDto", reviewDto);
			request.setAttribute("userDto", userDto);
			request.setAttribute("shopDto", shopDto);
			request.setAttribute("linkMap", linkMap);
			
			contentPath = "/page/review/view.jsp";
			
		} else if (reviewDto.getIsBlind() == 1) {
			contentPath = "/page/review/blind.jsp";
		} else {
			contentPath = "/page/error/error.jsp";
		}
		
		request.setAttribute("titleTagValue", "야진짜");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/page/review/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/review/include/bottom.jsp");
		
		return "/template/default/default.jsp";
	}

}
