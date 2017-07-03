package com.secondproject.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.secondproject.constant.ContextPath;

@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private String saveDirectory;
	private String defaultFolder;
	private int maxPostSize;
	private String encoding;
	
	public void init(ServletConfig config) {
		context = config.getServletContext();
		maxPostSize = 10 * 1024 * 1024;
		encoding = "EUC-KR";
		defaultFolder = "tmp";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveDirectory = context.getRealPath("/upload");
		String returnPath = ContextPath.root + "/upload";
		String QueryString = request.getQueryString().trim();
		String key = "";
		String value = "";
		
		if (QueryString.isEmpty() == false) {
			StringTokenizer token = new StringTokenizer(QueryString, "=");
			key = token.nextToken();
			if (key != null && key.equals("folder")) {
				value = token.nextToken().trim();
				if (value.isEmpty() == false) {
					saveDirectory += "/" + value;
					returnPath += "/" + value;
				}
			}
		} else {
			saveDirectory += "/" + defaultFolder;
			returnPath += "/" + defaultFolder;
		}
		
		String uploadFolder = mkDirYYYYMMDD();
		System.out.println(saveDirectory);
		
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadFolder, maxPostSize, encoding, new MyFileRenamePolicy());
		
		String filePath = returnPath + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/";
		response.getWriter().println(filePath + multipartRequest.getFilesystemName("uploadFile"));
	}

	private String mkDirYYYYMMDD() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String uploadFolder = saveDirectory + File.separator + dateFormat.format(new Date());
		mkDir(uploadFolder);
		dateFormat = new SimpleDateFormat("MM");
		uploadFolder += "/" + dateFormat.format(new Date());
		mkDir(uploadFolder);
		dateFormat = new SimpleDateFormat("dd");
		uploadFolder += "/" + dateFormat.format(new Date());
		mkDir(uploadFolder);
		return uploadFolder;
	}
	
	private void mkDir(String uploadFolder) {
		File folder = new File(uploadFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
}
