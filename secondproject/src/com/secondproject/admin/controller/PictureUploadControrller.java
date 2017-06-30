package com.secondproject.admin.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.constant.ContextPath;
import com.secondproject.factory.AdminFactory;
import com.secondproject.util.*;

@WebServlet("/picture")
public class PictureUploadControrller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String saveDirectory;
	private int maxPostSize;
	private String encoding;

	public void init(ServletConfig config) {
		ServletContext context = config.getServletContext();
		saveDirectory = context.getRealPath("/upload");
		maxPostSize = 3 * 1024 * 1024;
		encoding = "EUC-KR";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int seq = Sequence.getSequenceNextVal("seq_exhibition_id");
		String upfolder = saveDirectory + File.separator + seq;

		File folder = new File(upfolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		System.out.println(saveDirectory);
		MultipartRequest multi = new MultipartRequest(request, upfolder, maxPostSize, encoding,
				new DefaultFileRenamePolicy());

		String act = multi.getParameter("act");

		// ~~~~~~~~~~~~~~~~~ thumbnail 이미지 만드는 곳~~~~~~~~~~~~~~~~~~~~

		String filename = "";
		int width = 100;
		int height = 70;

		File SrcImgFile = new File(upfolder + File.separator + multi.getFilesystemName("picturename"));
		BufferedImage srcImg = ImageIO.read(SrcImgFile);

		BufferedImage thumbImg;

		thumbImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

		java.awt.Graphics2D g = thumbImg.createGraphics();

		g.drawImage(srcImg, 0, 0, width, height, null);

		File outFile = new File(upfolder + File.separator + "thumb_" + multi.getFilesystemName("picturename"));

		ImageIO.write(thumbImg, "PNG", outFile);

		int visiable = 0;
		if (NumberCheck.nullToZero(multi.getParameter("isvisiable")) == 0) {
			visiable = 0;
		} else {
			visiable = 1;
		}

		ExhibitionDto exhibitionDto = new ExhibitionDto();
		exhibitionDto.setExhibitionId(seq);
		exhibitionDto.setExTitle(multi.getParameter("subject"));
		exhibitionDto.setExDesc(multi.getParameter("content"));
		exhibitionDto.setExImage(multi.getFilesystemName("picturename"));
		exhibitionDto.setExVisiable(visiable);
		request.setAttribute("exhibitionInfo", exhibitionDto);

		String path = "/template/admin/admin.jsp";
		String contentPath = AdminFactory.getExhibitionWriteAction().execute(request, response);
		request.setAttribute("titleTagValue", "타이틀");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
		PageMove.forward(path, request, response);
	}
}