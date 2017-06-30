package com.secondproject.admin.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/thumbnail")
public class ThumbnailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String imagePath = context.getRealPath("image");

		int size = 10 * 1024 * 1024; // 10기가로 제한
		String filename = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, imagePath, size, "UTF-8",
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();

			String file = (String) files.nextElement();
			filename = multi.getFilesystemName(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ParameterBlock pb = new ParameterBlock();
		pb.add(imagePath + "/" + filename);
		RenderedOp rOp = JAI.create("fileload", pb);
		BufferedImage bi = rOp.getAsBufferedImage();
		BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = thumb.createGraphics();
		g.drawImage(bi, 0, 0, 100, 100, null);

		File file = new File(imagePath + "/thumb_" + filename);
		ImageIO.write(thumb, "jpg", file);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
