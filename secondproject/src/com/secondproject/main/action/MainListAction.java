package com.secondproject.main.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.main.model.MainExhibitionDto;
import com.secondproject.main.service.MainServiceImpl;

public class MainListAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();	
		
		List<ExhibitionDto> mainlist = ExhibitionServiceImpl.getExhibitionService().listExhibition(params);
		List<MainExhibitionDto> mainShoplist = MainServiceImpl.getMainService().listMainExhibition();
		
		request.setAttribute("mainlist", mainlist);
		request.setAttribute("mainShoplist", mainShoplist);
		return "/page/main/main.jsp";
	}

}