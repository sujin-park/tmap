package com.secondproject.mypage.model;

public class ReviewCommentDto {
	private int reviewCommentId;
	private int reviewId;
	private int userid;
	private String reviewContent;

	public int getReviewCommentId() {
		return reviewCommentId;
	}

	public void setReviewCommentId(int reviewCommentId) {
		this.reviewCommentId = reviewCommentId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

}
