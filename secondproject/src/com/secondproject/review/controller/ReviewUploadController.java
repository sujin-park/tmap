package com.secondproject.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.secondproject.factory.ReviewFactory;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.PageMove;
import com.secondproject.util.Sequence;
import com.secondproject.util.Uploader;

@WebServlet("/reviewFile")
public class ReviewUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		Uploader uploader = new Uploader(request, 10, "EUC-KR", "review");
		MultipartRequest multipartRequest = uploader.doUploadAndReturnRequest();
		String filePath = uploader.getFilePath();
		System.out.println("filePath = " + filePath);
		
		int seq = Sequence.getSequenceNextVal("SEQ_REVIEW_ID");
		int shopId = NumberCheck.nullToZero(multipartRequest.getParameter("shopId"));
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		int score = Integer.parseInt(multipartRequest.getParameter("score"));
		
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setReviewId(seq);
		reviewDto.setShopId(shopId);
		// TODO User ID 세션에서 얻어올 것
		reviewDto.setUserId(1);
		reviewDto.setTitle(title);
		reviewDto.setContent(content);
		reviewDto.setScore(score);
		reviewDto.setImg(filePath + "/" + multipartRequest.getFilesystemName("shopImg"));
		
		int isSuccess = ReviewServiceImpl.getReviewService().addReview(reviewDto);
		
		if (isSuccess == 1) {
			PageMove.redirect("/review?act=view&reviewId=" + seq, request, response);
		}
	}

}
