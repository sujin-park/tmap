package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.util.NumberCheck;

public class ExhibitionWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExhibitionDetailDto exhibitionDetailDto = new ExhibitionDetailDto();
		
		String path = "/adminIndex.jsp";
		int seq = ExhibitionDaoImpl.getExhibitionDao().getNextSeq(); // 글 번호 얻기 db에서
		String subject = request.getParameter("subject");
		int visiable = 0;
		int order = 6;
		if (NumberCheck.nullToZero(request.getParameter("checkbox1")) == 0) {
			visiable = 0;
		} else {
			visiable = 1;
		}
		exhibitionDetailDto.setExhibitionId(seq);
		exhibitionDetailDto.setExTitle(request.getParameter("subject"));
		exhibitionDetailDto.setExDesc(request.getParameter("content"));
		exhibitionDetailDto.setExImage("asdfsdf");
		exhibitionDetailDto.setExOrder(++order); // 일단 6번째 기획전이라고 가정 8ㅅ8 가정좀 그만해,,
		exhibitionDetailDto.setExVisiable(visiable); // 체크박스 value값 나오게 하기
		exhibitionDetailDto.setShopId(1); // 매장명을 받아서 dto에 shopId로 어떻게 저장할건지..좀 더 고민..
		exhibitionDetailDto.setExdOrder(1); // 일단 첫번째라고 가정  
		exhibitionDetailDto.setExdDesc("매장코멘트"); // 가정하기
		
		int cnt = ExhibitionServiceImpl.getExhibitionService().writeExhibition(exhibitionDetailDto);
		if (cnt != 0) {
			request.setAttribute("exhibitionInfo", exhibitionDetailDto);
			path = "/page/adminpage/expage/view.jsp";
		} else {
			path = "/page/adminpage/expage/writeFail.jsp";
		}
		return path;
	}

}