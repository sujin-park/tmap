package com.secondproject.main.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.main.model.MainExhibitionDto;
import com.secondproject.main.service.MainServiceImpl;

public class MainListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<MainExhibitionDto> mainList = MainServiceImpl.getMainService().listMainExhibition();
		
		request.setAttribute("mainlist", mainList);
		return "/page/main/main.jsp";
	}

}