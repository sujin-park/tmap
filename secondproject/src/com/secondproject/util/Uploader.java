package com.secondproject.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class Uploader {
	
	private int maxPostSizeByMB;
	private String encoding;
	private String realPath;
	private HttpServletRequest request;
	private String uploadFolder;
	private String filePath;
	
	public Uploader(HttpServletRequest request) {
		this(request, 10, "EUC-KR", "tmp");
	}
	
	public Uploader(HttpServletRequest request, int maxPostSizeByMB, String encoding, String saveFolder) {
		this.request = request;
		this.realPath = request.getServletContext().getRealPath("/upload/" + saveFolder);
		this.filePath = "/upload/" + saveFolder;
		this.maxPostSizeByMB = maxPostSizeByMB * 1024 * 1024;
		this.encoding = encoding;
		this.uploadFolder = mkDirYYYYMMDD();
	}
	
	public MultipartRequest doUploadAndReturnRequest() {
		MultipartRequest multipartRequest = null;
		try {
			multipartRequest = new MultipartRequest(request, uploadFolder, maxPostSizeByMB, encoding, new MyFileRenamePolicy());
			//System.out.println("uploadPath : " + uploadFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multipartRequest;
	}

	public String getFilePath() {
		return filePath;
	}
	
	private String mkDirYYYYMMDD() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String uploadFolder = realPath + "/" + dateFormat.format(new Date());
		filePath += "/" + dateFormat.format(new Date());
		mkDir(uploadFolder);
		
		dateFormat = new SimpleDateFormat("MM");
		uploadFolder += "/" + dateFormat.format(new Date());
		filePath += "/" + dateFormat.format(new Date());
		mkDir(uploadFolder);
		
		dateFormat = new SimpleDateFormat("dd");
		uploadFolder += "/" + dateFormat.format(new Date());
		filePath += "/" + dateFormat.format(new Date());
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
