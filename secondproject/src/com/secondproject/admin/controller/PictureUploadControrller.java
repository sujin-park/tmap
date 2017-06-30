package com.secondproject.admin.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.util.PageMove;


@WebServlet("/picture")
public class PictureUploadControrller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String saveDirectory;
	private int maxPostSize;
	private String encoding;

	public void init(ServletConfig config) {
		ServletContext context = config.getServletContext();
		saveDirectory = context.getRealPath("/upload/album");
		maxPostSize = 3 * 1024 * 1024;
		encoding = "EUC-KR";
		
	}
	// 어차피 File Upload는 get방식이 아닌 post 방식만 사용 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String today = df.format(new Date());
		String upfolder = saveDirectory + File.separator + today; // 앨범\170626 ( File.separator는 구분자 => \ ) 
		File folder = new File(upfolder);
		if (!folder.exists()) { // 파일이 존재하지않는다면
			folder.mkdirs(); // 폴더 만드는것
		}// 실제 저장된 폴더까지 셋팅 됨 
		System.out.println(saveDirectory);
		MultipartRequest multi = new MultipartRequest(request, upfolder, maxPostSize, encoding, new DefaultFileRenamePolicy());
	
		String act = multi.getParameter("act"); // multipartRequest를 할때는 multi.getparameter로 해야함
		
			
			ExhibitionDto exhibitionDto = new ExhibitionDto();
			
			exhibitionDto.setExhibitionId(1);
			exhibitionDto.setExDesc(multi.getParameter("content"));
			exhibitionDto.setExImage(multi.getFilesystemName("picturename"));
			exhibitionDto.setExOrder(1);
			exhibitionDto.setExTitle(multi.getParameter("subject"));
			exhibitionDto.setExVisiable(1);
			
		String path = "/page/adminpage/expage/exhibitioin.jsp";
		PageMove.forward(path, request, response);
	}
}