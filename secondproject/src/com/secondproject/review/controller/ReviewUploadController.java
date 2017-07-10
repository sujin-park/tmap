package com.secondproject.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.PageMove;
import com.secondproject.util.Sequence;
import com.secondproject.util.Uploader;
import com.secondproject.util.validation.LoginCheck;

@WebServlet("/reviewFile")
public class ReviewUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		boolean isLogin = LoginCheck.isLogin(request);
		
		if (isLogin == false) {
			PageMove.forward("/page/error/login.jsp", request, response);
		} else {
			Uploader uploader = new Uploader(request, 10, "EUC-KR", "review");
			MultipartRequest multipartRequest = uploader.doUploadAndReturnRequest();
			String act = multipartRequest.getParameter("act");
			
			int shopId = NumberCheck.nullToZero(multipartRequest.getParameter("shopId"));
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			int score = Integer.parseInt(multipartRequest.getParameter("score"));
			UserDto loginUserDto = (UserDto) request.getSession().getAttribute("logininfo");
			ReviewDto reviewDto = new ReviewDto();
			reviewDto.setShopId(shopId);
			reviewDto.setTitle(title);
			reviewDto.setContent(content);
			reviewDto.setScore(score);
			
			String filePath = uploader.getFilePath();
			String uploadFileName = multipartRequest.getFilesystemName("shopImg");
			
			if (uploadFileName != null) {
				reviewDto.setImg(filePath + "/" + multipartRequest.getFilesystemName("shopImg"));
			}
			
			if ("write".equals(act)) {
				
				int seq = Sequence.getSequenceNextVal("SEQ_REVIEW_ID");
				reviewDto.setReviewId(seq);
				reviewDto.setUserId(loginUserDto.getUser_id());

				int isSuccess = ReviewServiceImpl.getReviewService().addReview(reviewDto);
				if (isSuccess == 1) {
					PageMove.redirect("/review?act=view&reviewId=" + seq, request, response);
				}
				
			} else if ("modify".equals(act)) {
				
				int reviewId = NumberCheck.nullToZero(multipartRequest.getParameter("reviewId"));
				ReviewDto reviewDtoForValidate = ReviewServiceImpl.getReviewService().getReview(reviewId);
				if (reviewDtoForValidate != null && loginUserDto.getUser_id() == reviewDtoForValidate.getUserId()) {
					reviewDto.setReviewId(reviewId);
					ReviewServiceImpl.getReviewService().modifyReview(reviewDto);
					PageMove.redirect("/review?act=view&reviewId=" + reviewId, request, response);
				}
				
			} else {
				
			}
			
			
		}
		
	}

}
