package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
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
		int order = Integer.parseInt(request.getParameter("changeroot"));
		if (NumberCheck.nullToZero(request.getParameter("isvisiable")) == 0) {
			visiable = 0;
		} else {
			visiable = 1;
		}
		exhibitionDetailDto.setExhibitionId(seq);
		exhibitionDetailDto.setExTitle(request.getParameter("subject"));
		exhibitionDetailDto.setExDesc(request.getParameter("content"));
		exhibitionDetailDto.setExImage("asdfsdf");
		exhibitionDetailDto.setExOrder(order); // 일단 6번째 기획전이라고 가정 8ㅅ8 가정좀 그만해,,
		exhibitionDetailDto.setExVisiable(visiable); // 체크박스 value값 나오게 하기
		
		int cnt = ExhibitionServiceImpl.getExhibitionService().writeExhibition(exhibitionDetailDto);
		if (cnt != 0) {
			request.setAttribute("exhibitionInfo", exhibitionDetailDto);
			path = "/page/adminpage/expage/view.jsp";
//			path = "/page/adminpage/expage/writeOk.jsp";
		} else {
			path = "/page/adminpage/expage/writeFail.jsp";
		}
		return path;
	}

}